package org.huayuzhang.booking.clients;

import org.huayuzhang.booking.pojo.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("doctorservice")
public interface DoctorClient {

    @GetMapping("/doctor/{id}")
    Doctor findById(@PathVariable("id") Long id);
}