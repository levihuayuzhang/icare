package org.ph1nix.payment.service;

import org.ph1nix.feign.clients.DoctorClient;
import org.ph1nix.feign.clients.PatientClient;
import org.ph1nix.feign.pojo.Doctor;
import org.ph1nix.feign.pojo.Patient;
import org.ph1nix.payment.mapper.PaymentMapper;
import org.ph1nix.payment.pojo.Payment;
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
