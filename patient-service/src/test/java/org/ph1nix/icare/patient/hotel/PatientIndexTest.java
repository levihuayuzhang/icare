package org.ph1nix.icare.patient.hotel;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ph1nix.icare.patient.hotel.pojo.Hotel;
import org.ph1nix.icare.patient.hotel.pojo.HotelDoc;
import org.ph1nix.icare.patient.hotel.pojo.Human;
import org.ph1nix.icare.patient.hotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;
import java.util.Objects;

@Slf4j(topic = "icare.es.test")
@SpringBootTest(classes = HotelDemoApplication.class) // for multiple application class
public class PatientIndexTest {
    @Autowired
    IHotelService hotelService;
    private RestClient restClient;
    private ElasticsearchTransport transport;
    private ElasticsearchClient client;
    private String host = "localhost";
    private int port = 9200;
    private FileReader file = new FileReader(new File("src/test/java/org/ph1nix/icare/patient/hotel/", "hotelIndex.json"));

    // use for trow exceptions
    public PatientIndexTest() throws FileNotFoundException {
    }

    @Test
    void testInit() {
        System.out.println(restClient);
    }

    /**
     * read index definition from json file
     * <a href="https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/loading-json.html">es doc</a>
     *
     * @throws IOException
     */
    @Test
    void createHotelIndex() throws IOException {
        CreateIndexRequest request = CreateIndexRequest.of(c -> c
                                        .index("hotel") // without id
                                        .withJson(file));
        // create index for hotel
        System.out.println(client.indices().create(request).acknowledged());
    }


    @Test
    void testExistHotelIndex() throws IOException {
        System.out.println(client.indices().exists(e -> e.index("hotel")).value() ? "Exist" : "Not exist");
    }

    @Test
    void testDeleteHotelIndex() throws IOException {
        DeleteIndexRequest request = DeleteIndexRequest.of(d -> d
                .index("hotel")); // without id

        System.out.println(client.indices().delete(request));
    }

    /**
     * store json file into es
     * update full documentation or create a new one if not exist already
     *
     * @throws IOException
     */
    @Test
    void createHotelDoc1() throws IOException {
        // read json document and store it
        IndexRequest<JsonData> req;
        req = IndexRequest.of(c -> {
            try {
                return c
                        .index("hotel")
                        .id("1") // with id
                        .withJson(new FileReader("src/test/java/org/ph1nix/icare/patient/hotel1.json")); // content root (module working directory)
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(client.index(req).result());
    }

    @Test
    void createHotelDoc2() throws IOException {

        Hotel hotel = hotelService.getById(36934L); // from database
        HotelDoc hotelDoc = new HotelDoc(hotel);
        ObjectMapper mapper = new ObjectMapper();

        IndexRequest<JsonData> req;
        req = IndexRequest.of(c-> {
                    try {
                        return c
                                .index("hotel")
                                .id(hotel.getId().toString())
                                .withJson(new StringReader( // Reader for json
                                        mapper.writeValueAsString( // map object and write to string
                                                JSON.toJSON(hotelDoc)))); // serialize
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        System.out.println(client.index(req));
    }

    @Test
    void testExistHotelDoc() throws IOException {
        System.out.println(client.exists(e->e.index("hotel").id("1")).value());
        System.out.println(client.exists(e->e.index("hotel").id("36934")).value());
    }

    @Test
    void testGetHotelDoc() throws IOException{
        HotelDoc hotelDoc1 = client.get(GetRequest.of(g -> g
                    .index("hotel")
                    .id("36934"))
                , HotelDoc.class).source(); // indicate class or type, deserialize json to object
        System.out.println("ID: " + Objects.requireNonNull(hotelDoc1).getId() + " price: " + hotelDoc1.getPrice());

        HotelDoc hotelDoc2 = client.get(GetRequest.of(g -> g
                        .index("hotel")
                        .id("38812"))
                , HotelDoc.class).source(); // indicate class or type, deserialize json to object
        System.out.println("ID: " + Objects.requireNonNull(hotelDoc2).getId() + " price: " + hotelDoc2.getPrice());

        if (client.get(GetRequest.of(g -> g
                        .index("hotel")
                        .id("1")
                ), Human.class)
                .source() != null) {

            // get human name or age
            System.out.println(Objects.requireNonNull(client.get(GetRequest.of(g -> g
                                    .index("hotel")
                                    .id("1")
                            ), Human.class)
                            .source())
                    // .getAge());
                    .getName());

            System.out.println(client.get(GetRequest.of(g -> g
                            .index("hotel")
                            .id("1")
                    ), Human.class)
                    .source()); // get pojo object
        }

    }

    /**
     * insertion update (partial document)
     *
     * @throws IOException
     */
    @Test
    void testUpdateDocById() throws IOException {
        // create object
        Human human = new Human();
        human.setAge(17);
        // human.setName("Damn");

        System.out.println(client.update(UpdateRequest.of(u -> u
                        .index("hotel")
                        .id("1")
                        .doc(human)) // bind object and parse value
                , Human.class).result());
    }

    @Test
    void testDeleteDocById() throws IOException {
        System.out.println(client.delete(d -> d
                .index("hotel")
                .id("1")
        ).result());
    }

    /**
     * add all data from mysql to es with bulk request
     * <a href="https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/indexing-bulk.html">es doc</a>
     *
     * @throws IOException
     */
    @Test
    void testBulk() throws IOException {
        List<Hotel> listHotel = hotelService.list(); // get hotel list, this requires spring application (Hotel)
        BulkRequest.Builder br = new BulkRequest.Builder();

        for (Hotel ht : listHotel) {
            HotelDoc hd = new HotelDoc(ht); // make each hotel to hotel doc

            br.operations(op -> op
                    .index(idx -> idx
                            .index("hotel")
                            .id(hd.getId().toString())
                            .document(hd)));
        }

        BulkResponse result = client.bulk(br.build());

        // error handling
        if (result.errors()) {
            log.error("Bulk had error(s)");

            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    log.error(item.error().reason());
                }
            }
        } else {
            System.out.println(result);
        }
    }

    /**
     * initialize the es client before each test
     *
     * @throws IOException
     */
    @BeforeEach
    void setUp() throws IOException {
        restClient = RestClient
                .builder(new HttpHost(host, port, "http")) // not using ssl as it require higher subscription of es
                .build();
        transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        client = new ElasticsearchClient(transport);
    }

    @AfterEach
    void tearDown() throws IOException {
        restClient.close();
    }
}
