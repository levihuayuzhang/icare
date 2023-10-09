package org.icare.payment.pojo;

import lombok.Data;
import org.icare.feign.pojo.Doctor;
import org.icare.feign.pojo.Patient;
/**
 * define the data fields of payment
 *
 * @author Huayu Zhang
 */
@Data
public class Payment {
    private Long pmID; // payment ID
    private String pmTime; // payment time

    private Long docID; // doctor ID
    private Long ptID; // patient ID

    private Doctor doctor;
    private Patient patient;
}
