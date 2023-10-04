package org.ph1nix.icare.patient;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
public class PatientIndexTest {
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
    void createHotelIndex1() throws IOException {
        CreateIndexRequest request = CreateIndexRequest.of(builder -> builder
                                        .index("hotel") // without id
                                        .withJson(file));
        // create index for hotel
        System.out.println(client.indices().create(request).acknowledged());
    }

    /**
     * store json document into es
     *
     * @throws IOException
     */
    @Test
    void createHotelIndex2() throws IOException {
        // read json document and store it
        IndexRequest<JsonData> req;
        req = IndexRequest.of(b -> b
                .index("hotel")
                .id("hotel") // with id
                .withJson(file));

        System.out.println(client.index(req));
    }

    @Test
    void testDeleteHotelIndex1() throws IOException {
        DeleteRequest request = DeleteRequest.of(builder -> builder
                                        .index("hotel")
                                        .id("hotel")); // with id

        System.out.println(client.delete(request));
    }

    @Test
    void testDeleteHotelIndex2() throws IOException {
        DeleteIndexRequest request = DeleteIndexRequest.of(builder -> builder
                .index("hotel")); // without id

        System.out.println(client.indices().delete(request));
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
