package org.ph1nix.icare.doctor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.ph1nix.icare.doctor.mapper")
@SpringBootApplication
public class DoctorApplication {
    /**
     * main method for doctor service starter class
     *
     * @param args application arguments
     * @author Huayu Zhang
     */
    public static void main(String[] args) {
        SpringApplication.run(DoctorApplication.class, args);
        System.out.println("\u001B[36m\nWelcome to iCare Doctor service" + " ^_^ \n" +
                "\u001B[34m" + " __        __   _                              _           "            + "\u001B[32m" + " ██  ▄████▄   ▄▄▄       ██▀███  ▓█████ \n" +
                "\u001B[34m" + " \\ \\      / /__| | ___ ___  _ __ ___   ___    | |_ ___     "          + "\u001B[32m" + "▓██▒ ██▀ ▀█  ▒████▄    ▓██ ▒ ██ ▓█   ▀ \n" +
                "\u001B[34m" + "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | __/ _ \\    "    + "\u001B[32m" + "▒██▒ ▓█    ▄ ▒██  ▀█▄  ▓██ ░▄█  ▒███   \n" +
                "\u001B[34m" + "   \\ V  V /  __/ | (_| (_) | | | | | |  __/   | || (_) |   "           + "\u001B[32m" + "░██░ ▓▓▄ ▄██ ░██▄▄▄▄██ ▒██▀▀█▄  ▒▓█  ▄ \n" +
                "\u001B[34m" + "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|    \\__\\___/    "    + "\u001B[32m" + "░██░  ▓███▀   ▓█   ▓██ ░██▓ ▒██ ░▒████▒\n" +
                "\u001B[0m" // reset color
        );
    }
}