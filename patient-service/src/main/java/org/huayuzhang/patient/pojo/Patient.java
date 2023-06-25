package org.huayuzhang.patient.pojo;

import lombok.Data;
@Data
public class Patient {
    private Long id; // patient ID
    private String patientName; // patient name
    private String phoneNum; // patient phone number
    private String address; // patient address
}