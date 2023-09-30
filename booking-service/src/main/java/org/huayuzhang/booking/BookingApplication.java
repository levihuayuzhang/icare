package org.huayuzhang.booking;

import lombok.extern.slf4j.Slf4j;
import org.huayuzhang.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * spring application class contain the main class for booking service
 */
@Slf4j
@MapperScan("org.huayuzhang.booking.mapper")
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class, basePackages = "org.huayuzhang.feign.clients")
public class BookingApplication {
    /**
     * main class of booking application
     *
     * @param args program arguments
     * @author: Huayu Zhang
     */
    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
        log.info("This is the booking boot application!");
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
