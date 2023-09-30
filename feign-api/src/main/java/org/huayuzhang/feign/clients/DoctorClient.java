package org.huayuzhang.feign.clients;

import org.huayuzhang.feign.pojo.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctorservice", url = "localhost:23002")
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
