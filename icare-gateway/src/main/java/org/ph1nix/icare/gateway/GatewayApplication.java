package org.icare.gateway;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import static org.icare.Constants.START_UP_ART;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) // gateway don't need to access database
public class GatewayApplication {
    /**
     * main class of gateway applications
     *
     * @param args application arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("\u001B[36m\nWelcome to iCare Gateway service" + " ^_^ \n" + START_UP_ART);
    }

    // convert mq messages from object to json
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
