package org.icare.doctor.pojo;

import lombok.Data;

/**
 * define the data fields of doctor
 *
 * @author Huayu Zhang
 */
@Data
public class Doctor {
    private Long id; // patient ID
    private String docName; // patient name
    private String phoneNum; // patient phone number
    private String department; // patient address
}