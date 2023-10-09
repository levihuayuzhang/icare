package org.icare.payment.web;

import org.icare.payment.pojo.Payment;
import org.icare.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{pmID}")
    public Payment queryByPaymentByPatientAndDoctorID(@PathVariable("pmID") Long pmID) {
        return paymentService.queryPaymentByID(pmID);
    }
}
