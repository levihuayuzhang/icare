package org.ph1nix.doctor.web;

import lombok.extern.slf4j.Slf4j;
import org.ph1nix.doctor.config.PatternProperties;
import org.ph1nix.doctor.pojo.Doctor;
import org.ph1nix.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/doctor")
@RefreshScope
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    // value injection
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @Autowired
    private PatternProperties properties;

    /**
     * test for dateformat pattern (nacos configuration center testing)
     *
     * @return the properties of datetime format
     * @author Huayu Zhang
     */
    @GetMapping("now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    /**
     * test for showing all pattern properties (nacos configuration center testing)
     *
     * @return pattern properties as a JSON package (include all configuration of pattern properties)
     * @author Huayu Zhang
     */
    @GetMapping("prop")
    public PatternProperties properties(){
        return properties;
    }

    /**
     * ip:port/patient/{id}
     * to access cloud_doctor database
     *
     * @param id doctor ID
     * @return database query in cloud_doctor for corresponding doctor ID
     */
    @GetMapping("/{id}")
    public Doctor queryById(@PathVariable("id") Long id) {
        return doctorService.queryById(id);
    }
}
