package org.icare.doctor.service;

import org.icare.doctor.mapper.DoctorMapper;
import org.icare.doctor.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * query doctor object by using doctor ID passed from request
     * @param id doctor ID
     * @return doctor object
     * @author Huayu Zhang
     */
    public Doctor queryById(Long id) {

        return doctorMapper.findById(id);
    }
}
