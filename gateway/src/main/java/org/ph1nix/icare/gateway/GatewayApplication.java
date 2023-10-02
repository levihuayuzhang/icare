package org.ph1nix.icare.gateway;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    /**
     * main class of gateway applications
     *
     * @param args application arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("\u001B[36m\nWelcome to iCare Gateway service" + " ^_^ \n" +
                "\u001B[34m" + " __        __   _                              _           "            + "\u001B[32m" + " ██  ▄████▄   ▄▄▄       ██▀███  ▓█████ \n" +
                "\u001B[34m" + " \\ \\      / /__| | ___ ___  _ __ ___   ___    | |_ ___     "          + "\u001B[32m" + "▓██▒ ██▀ ▀█  ▒████▄    ▓██ ▒ ██ ▓█   ▀ \n" +
                "\u001B[34m" + "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | __/ _ \\    "    + "\u001B[32m" + "▒██▒ ▓█    ▄ ▒██  ▀█▄  ▓██ ░▄█  ▒███   \n" +
                "\u001B[34m" + "   \\ V  V /  __/ | (_| (_) | | | | | |  __/   | || (_) |   "           + "\u001B[32m" + "░██░ ▓▓▄ ▄██ ░██▄▄▄▄██ ▒██▀▀█▄  ▒▓█  ▄ \n" +
                "\u001B[34m" + "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|    \\__\\___/    "    + "\u001B[32m" + "░██░  ▓███▀   ▓█   ▓██ ░██▓ ▒██ ░▒████▒\n" +
                "\u001B[0m" // reset color
        );
    }

    // convert mq messages from object to json
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
