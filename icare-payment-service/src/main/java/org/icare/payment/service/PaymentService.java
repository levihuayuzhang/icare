package org.icare.payment.service;

import org.icare.feign.clients.DoctorClient;
import org.icare.feign.clients.PatientClient;
import org.icare.feign.pojo.Doctor;
import org.icare.feign.pojo.Patient;
import org.icare.payment.mapper.PaymentMapper;
import org.icare.payment.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private PatientClient patientClient;
    /**
     * query doctor object by using payment ID passed from request
     * @param pmID payment ID
     * @return payment object
     * @author Huayu Zhang
     */
    public Payment queryPaymentByID(Long pmID) {
        Payment payment = paymentMapper.findById(pmID);

        // feign RPC
        Doctor doctor = doctorClient.findById(payment.getDocID());
        Patient patient = patientClient.findById(payment.getPtID());

        payment.setDoctor(doctor);
        payment.setPatient(patient);

        return payment;
    }
}
