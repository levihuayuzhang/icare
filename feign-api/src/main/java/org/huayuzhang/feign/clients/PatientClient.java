package org.huayuzhang.feign.clients;

import org.huayuzhang.feign.pojo.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patientservice", url = "localhost:23001")
public interface PatientClient {
    /**
     * define the path mapping of feign API request
     *
     * @param id patient ID
     * @return patient object
     * @author Huayu Zhang
     */
    @GetMapping("/patient/{id}")
    Patient findById(@PathVariable("id") Long id);
}
