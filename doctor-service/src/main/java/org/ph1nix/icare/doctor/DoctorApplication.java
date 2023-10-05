package org.ph1nix.icare.doctor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.ph1nix.icare.Constants.START_UP_ART;

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
        System.out.println("\u001B[36m\nWelcome to iCare Doctor service" + " ^_^ \n" + START_UP_ART);
    }
}