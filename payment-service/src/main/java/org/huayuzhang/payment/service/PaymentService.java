package org.huayuzhang.payment.service;

import org.huayuzhang.feign.clients.DoctorClient;
import org.huayuzhang.feign.clients.PatientClient;
import org.huayuzhang.feign.pojo.Doctor;
import org.huayuzhang.feign.pojo.Patient;
import org.huayuzhang.payment.mapper.PaymentMapper;
import org.huayuzhang.payment.pojo.Payment;
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
