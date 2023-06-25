package org.huayuzhang.doctor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.huayuzhang.doctor.mapper")
@SpringBootApplication
public class DoctorApplication {
    public static void main(String[] args) {

        SpringApplication.run(DoctorApplication.class, args);
    }
}