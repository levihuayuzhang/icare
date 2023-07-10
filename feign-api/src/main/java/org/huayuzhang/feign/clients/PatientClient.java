package org.huayuzhang.feign.clients;

import org.huayuzhang.feign.pojo.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("patientservice")
public interface PatientClient {

    @GetMapping("/patient/{id}")
    Patient findById(@PathVariable("id") Long id);
}
