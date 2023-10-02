package org.ph1nix.icare.patient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 */
@MapperScan("org.ph1nix.icare.patient.mapper")
@SpringBootApplication
public class PatientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
        System.out.println("\u001B[36m\nWelcome to iCare Patient service" + " ^_^ \n" +
                "\u001B[34m" + " __        __   _                              _           "            + "\u001B[32m" + " ██  ▄████▄   ▄▄▄       ██▀███  ▓█████ \n" +
                "\u001B[34m" + " \\ \\      / /__| | ___ ___  _ __ ___   ___    | |_ ___     "          + "\u001B[32m" + "▓██▒ ██▀ ▀█  ▒████▄    ▓██ ▒ ██ ▓█   ▀ \n" +
                "\u001B[34m" + "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | __/ _ \\    "    + "\u001B[32m" + "▒██▒ ▓█    ▄ ▒██  ▀█▄  ▓██ ░▄█  ▒███   \n" +
                "\u001B[34m" + "   \\ V  V /  __/ | (_| (_) | | | | | |  __/   | || (_) |   "           + "\u001B[32m" + "░██░ ▓▓▄ ▄██ ░██▄▄▄▄██ ▒██▀▀█▄  ▒▓█  ▄ \n" +
                "\u001B[34m" + "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|    \\__\\___/    "    + "\u001B[32m" + "░██░  ▓███▀   ▓█   ▓██ ░██▓ ▒██ ░▒████▒\n" +
                "\u001B[0m" // reset color
        );
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}