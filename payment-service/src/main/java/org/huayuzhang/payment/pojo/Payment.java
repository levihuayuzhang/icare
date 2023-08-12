package org.huayuzhang.payment.pojo;

import lombok.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.huayuzhang.feign.pojo.Doctor;
import org.huayuzhang.feign.pojo.Patient;

@Data
public class Payment {
    private Long pmID; // payment ID

    private SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date date = new Date();
    private String paymentTime = sdf.format(date);

    private Long docID; // doctor ID
    private Long ptID; // patient ID

    private Doctor doctor;
    private Patient patient;
}
