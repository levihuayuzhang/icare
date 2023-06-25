package org.huayuzhang.doctor.service;

import org.huayuzhang.doctor.mapper.DoctorMapper;
import org.huayuzhang.doctor.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    public Doctor queryById(Long id) {

        return doctorMapper.findById(id);
    }
}
