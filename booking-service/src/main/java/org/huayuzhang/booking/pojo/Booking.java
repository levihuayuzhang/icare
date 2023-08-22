package org.huayuzhang.booking.pojo;

import lombok.Data;
import org.huayuzhang.feign.pojo.Doctor;
import org.huayuzhang.feign.pojo.Patient;

/**
 * Pojo Class for containing booking data
 *
 * @author Huayu Zhang
 * @since JDK 1.8
 */
@Data
public class Booking {
    private Long bkID; // booking ID
    private String bkDate; // booking date
    private String bkSlot; // booking slot (0.5h for 1 slot, 8:00 to 12:00 (slot 1 to 8), 14:00 to 17:00(slot 8 to 14))

    private Long docID; // doctor ID
    private Long ptID; // patient ID

    private Doctor doctor;
    private Patient patient;
}
