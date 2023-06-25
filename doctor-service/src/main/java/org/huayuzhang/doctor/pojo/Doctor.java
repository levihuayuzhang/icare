package org.huayuzhang.doctor.pojo;

import lombok.Data;
@Data
public class Doctor {
    private Long id; // patient ID
    private String docName; // patient name
    private String phoneNum; // patient phone number
    private String department; // patient address
}