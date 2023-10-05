package org.ph1nix.icare.patient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import static org.ph1nix.icare.Constants.START_UP_ART;

/**
 *
 */
@MapperScan("org.ph1nix.icare.patient.mapper")
@SpringBootApplication
public class PatientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
        System.out.println("\u001B[36m\nWelcome to iCare Patient service" + " ^_^ \n" + START_UP_ART);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}