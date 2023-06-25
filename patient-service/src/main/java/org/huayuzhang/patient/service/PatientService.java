package org.huayuzhang.patient.service;

import org.huayuzhang.patient.mapper.PatientMapper;
import org.huayuzhang.patient.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientMapper patientMapper;

    public Patient queryById(Long id) {
        return patientMapper.findById(id);
    }
}
