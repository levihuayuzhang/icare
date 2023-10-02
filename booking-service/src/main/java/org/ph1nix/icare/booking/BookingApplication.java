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
        System.out.println("\u001B[36m\nWelcome to iCare ^_^ \n" +
                "\u001B[34m" + " __        __   _                              _           "            + "\u001B[32m" + " ██  ▄████▄   ▄▄▄       ██▀███  ▓█████ \n" +
                "\u001B[34m" + " \\ \\      / /__| | ___ ___  _ __ ___   ___    | |_ ___     "          + "\u001B[32m" + "▓██▒ ██▀ ▀█  ▒████▄    ▓██ ▒ ██ ▓█   ▀ \n" +
                "\u001B[34m" + "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | __/ _ \\    "    + "\u001B[32m" + "▒██▒ ▓█    ▄ ▒██  ▀█▄  ▓██ ░▄█  ▒███   \n" +
                "\u001B[34m" + "   \\ V  V /  __/ | (_| (_) | | | | | |  __/   | || (_) |   "           + "\u001B[32m" + "░██░ ▓▓▄ ▄██ ░██▄▄▄▄██ ▒██▀▀█▄  ▒▓█  ▄ \n" +
                "\u001B[34m" + "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|    \\__\\___/    "    + "\u001B[32m" + "░██░  ▓███▀   ▓█   ▓██ ░██▓ ▒██ ░▒████▒\n" +
                "\u001B[0m" // reset color
        );
        // log.info("This is the booking boot application!");
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
