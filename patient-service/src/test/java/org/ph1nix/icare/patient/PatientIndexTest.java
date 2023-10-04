package org.ph1nix.icare.patient;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PatientIndexTest {
    private RestClient restClient;
    private String serverUrl = "https://localhost:9200";
    private String apiKey = "VnVhQ2ZHY0JDZGJrU...";

    @Test
    void testInit() {
        System.out.println(restClient);
    }

    @BeforeEach
    void setUp() {
        restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization", "ApiKey " + apiKey)
                })
                .build();
    }

    @AfterEach
    void tearDown() throws IOException {
        restClient.close();
    }
}
