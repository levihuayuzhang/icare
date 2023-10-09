package org.icare.patient.service;

import org.icare.patient.mapper.PatientMapper;
import org.icare.patient.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientMapper patientMapper;
    /**
     * query doctor object by using patient ID passed from request
     * @param id patient ID
     * @return patient object
     * @author Huayu Zhang
     */

    public Patient queryById(Long id) {
        return patientMapper.findById(id);
    }
}
