package org.ph1nix.doctor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.ph1nix.doctor.mapper")
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
    }
}