package org.huayuzhang.doctor.web;

import lombok.extern.slf4j.Slf4j;
import org.huayuzhang.doctor.config.PatternProperties;
import org.huayuzhang.doctor.pojo.Doctor;
import org.huayuzhang.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/doctor")
//@RefreshScope
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    // value injection
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @Autowired
    private PatternProperties properties;

    // test for dateformat pattern (nacos configuration center testing)
    @GetMapping("now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    // test for showing all pattern properties (nacos configuration center testing)
    @GetMapping("prop")
    public PatternProperties properties(){
        return properties;
    }

    /**
     * ip:port/patient/{id}
     * to access cloud_doctor database
     *
     * @param id
     * @return database query in cloud_doctor for corresponding doctor ID
     */
    @GetMapping("/{id}")
    public Doctor queryById(@PathVariable("id") Long id) {
        return doctorService.queryById(id);
    }
}
