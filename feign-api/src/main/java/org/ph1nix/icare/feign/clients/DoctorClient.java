package org.ph1nix.icare.feign.clients;

import org.ph1nix.icare.feign.pojo.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctorservice")
public interface DoctorClient {
    /**
     * define the path mapping of feign API request
     *
     * @param id doctor ID
     * @return doctor object
     * @author Huayu Zhang
     */
    @GetMapping("/doctor/{id}")
    Doctor findById(@PathVariable("id") Long id);
}
