package org.icare.doctor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.icare.Constants.START_UP_ART;

@MapperScan("org.icare.doctor.mapper")
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