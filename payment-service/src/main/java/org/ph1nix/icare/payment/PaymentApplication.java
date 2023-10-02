package org.ph1nix.icare.payment;

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

@MapperScan("org.ph1nix.icare.payment.mapper")
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class, basePackages = "org.ph1nix.icare.feign.clients")
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
        System.out.println("\u001B[36m\nWelcome to iCare Payment service" + " ^_^ \n" +
                "\u001B[34m" + " __        __   _                              _           "            + "\u001B[32m" + " ██  ▄████▄   ▄▄▄       ██▀███  ▓█████ \n" +
                "\u001B[34m" + " \\ \\      / /__| | ___ ___  _ __ ___   ___    | |_ ___     "          + "\u001B[32m" + "▓██▒ ██▀ ▀█  ▒████▄    ▓██ ▒ ██ ▓█   ▀ \n" +
                "\u001B[34m" + "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | __/ _ \\    "    + "\u001B[32m" + "▒██▒ ▓█    ▄ ▒██  ▀█▄  ▓██ ░▄█  ▒███   \n" +
                "\u001B[34m" + "   \\ V  V /  __/ | (_| (_) | | | | | |  __/   | || (_) |   "           + "\u001B[32m" + "░██░ ▓▓▄ ▄██ ░██▄▄▄▄██ ▒██▀▀█▄  ▒▓█  ▄ \n" +
                "\u001B[34m" + "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|    \\__\\___/    "    + "\u001B[32m" + "░██░  ▓███▀   ▓█   ▓██ ░██▓ ▒██ ░▒████▒\n" +
                "\u001B[0m" // reset color
        );
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
