package org.huayuzhang.feign.pojo;

import lombok.Data;

/**
 * define the data filed of doctor
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
