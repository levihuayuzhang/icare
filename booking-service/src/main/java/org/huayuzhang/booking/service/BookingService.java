package org.huayuzhang.booking.service;

import org.huayuzhang.booking.clients.DoctorClient;
import org.huayuzhang.booking.clients.PatientClient;
import org.huayuzhang.booking.mapper.BookingMapper;
import org.huayuzhang.booking.pojo.Booking;
import org.huayuzhang.booking.pojo.Doctor;
import org.huayuzhang.booking.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {
    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private PatientClient patientClient;

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
