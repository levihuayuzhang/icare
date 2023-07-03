package org.huayuzhang.patient.pojo;

import lombok.Data;
@Data
public class Patient {
    private Long id; // patient ID
    private String patientName; // patient name
    private Integer gender; // patient gender (biological) (0 for female, 1 for male)
    private String phoneNum; // patient phone number
    private String address; // patient address
}