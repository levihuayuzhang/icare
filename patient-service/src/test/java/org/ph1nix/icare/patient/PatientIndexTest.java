package org.ph1nix.icare.patient;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.GetIndexRequest;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ph1nix.icare.patient.pojo.Hotel;
import org.ph1nix.icare.patient.pojo.HotelDoc;
import org.ph1nix.icare.patient.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

@SpringBootTest
public class PatientIndexTest {
    @Autowired
    IHotelService hotelService;
    private RestClient restClient;
    private ElasticsearchTransport transport;
    private ElasticsearchClient client;
    private String host = "localhost";
    private int port = 9200;
    private FileReader file;
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
     * store json document into es
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
                        .withJson(new FileReader("src/test/java/org/ph1nix/icare/patient/hotel1.json"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(client.index(req));
    }

    @Test
    void createHotelDoc2() throws IOException {

        Hotel hotel = hotelService.getById(36934L);
        HotelDoc hotelDoc = new HotelDoc(hotel);

        IndexRequest<JsonData> req;
        req = IndexRequest.of(c->c
                .index("hotel")
                .id(hotel.getId().toString())
                .document((JsonData) hotelDoc)
        );

        System.out.println(client.index(req));
    }

    @Test
    void testExistHotelDoc() throws IOException {
        System.out.println(client.exists(e->e.index("hotel").id("1")).value());
    }

    @Test
    void testGetHotelDoc() throws IOException {
        GetRequest request = GetRequest.of(g->g.index("hotel").id("1"));
        // System.out.println(client.get(request, );
    }

    @Test
    void testDeleteHotelDoc() throws IOException {
        DeleteRequest request = DeleteRequest.of(d -> d
                .index("hotel")
                .id("1")); // with id

        System.out.println(client.delete(request));
    }



    @BeforeEach
    void setUp() throws IOException {
        restClient = RestClient
                .builder(new HttpHost(host, port, "http")) // not using ssl as it require higher subscription of es
                .build();
        transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        client = new ElasticsearchClient(transport);
        file = new FileReader(new File("src/test/java/org/ph1nix/icare/patient/", "hotelIndex.json"));
    }

    @AfterEach
    void tearDown() throws IOException {
        restClient.close();
    }
}