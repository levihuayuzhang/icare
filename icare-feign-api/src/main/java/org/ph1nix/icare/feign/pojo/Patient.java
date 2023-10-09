package org.icare.feign.pojo;

import lombok.Data;
/**
 * define the data filed of patient
 *
 * @author Huayu Zhang
 */
@Data
public class Patient {
    private Long id; // patient ID
    private String patientName; // patient name
    private Integer gender; // patient gender (biological) (0 for female, 1 for male)
    private String phoneNum; // patient phone number
    private String address; // patient address
}
