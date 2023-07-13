package org.huayuzhang.patient.web;

import lombok.extern.slf4j.Slf4j;
import org.huayuzhang.patient.config.PatternProperties;
import org.huayuzhang.patient.pojo.Patient;
import org.huayuzhang.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/patient")
@RefreshScope
public class PatientController {
    @Autowired
    private PatientService patientService;

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
     * to access cloud_patient database
     *
     * @param id
     * @return database query in cloud_patient for corresponding patient ID
     */
    @GetMapping("/{id}")
    public Patient queryById(@PathVariable("id") Long id, @RequestHeader(value="rfp", required = false) String rfp, @RequestHeader(value="rf", required = false) String rf) {
        System.out.println("Request filter for patient service: " + rfp);
        System.out.println("Request filter for all service: " + rf);
        return patientService.queryById(id);
    }
}
