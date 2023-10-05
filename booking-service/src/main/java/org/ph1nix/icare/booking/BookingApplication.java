package org.ph1nix.icare.booking;

import lombok.extern.slf4j.Slf4j;
import org.ph1nix.icare.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import static org.ph1nix.icare.Constants.START_UP_ART;

/**
 * spring application class contain the main class for booking service
 */
@Slf4j
@MapperScan("org.ph1nix.icare.booking.mapper")
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class, basePackages = "org.ph1nix.icare.feign.clients")
public class BookingApplication {
    /**
     * main class of booking application
     *
     * @param args program arguments
     * @author: Huayu Zhang
     */
    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
        System.out.println("\u001B[36m\nWelcome to iCare Booking service" + " ^_^ \n" + START_UP_ART);
    }

    /**
     * create RestTemplate and inject Spring container
     *
     * @return RestTemplate class object
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
