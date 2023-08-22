package org.huayuzhang.booking.service;

import org.huayuzhang.feign.clients.DoctorClient;
import org.huayuzhang.feign.clients.PatientClient;
import org.huayuzhang.booking.mapper.BookingMapper;
import org.huayuzhang.booking.pojo.Booking;
import org.huayuzhang.feign.pojo.Doctor;
import org.huayuzhang.feign.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service class of Booking service
 *
 * @author Huayu Zhang
 * @since JDK 1.8
 */
@Service
public class BookingService {
    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private PatientClient patientClient;

    /**
     * Query Booking object by using booking ID
     * @param bkID booking ID
     * @return the target Booking object
     */
    public Booking queryBookingById(Long bkID) {
        // query for booking
        Booking booking = bookingMapper.findById(bkID);

        // feign RPC
        Doctor doctor = doctorClient.findById(booking.getDocID());
        Patient patient = patientClient.findById(booking.getPtID());

        booking.setDoctor(doctor);
        booking.setPatient(patient);

        return booking;
    }
}
