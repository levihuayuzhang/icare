package org.huayuzhang.payment.pojo;

import lombok.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.huayuzhang.feign.pojo.Doctor;
import org.huayuzhang.feign.pojo.Patient;

@Data
public class Payment {
    private Long pmID; // payment ID
    private String pmTime; // payment time

    private Long docID; // doctor ID
    private Long ptID; // patient ID

    private Doctor doctor;
    private Patient patient;
}
