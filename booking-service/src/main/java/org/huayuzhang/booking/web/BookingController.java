package org.huayuzhang.booking.web;

import org.huayuzhang.booking.pojo.Booking;
import org.huayuzhang.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * web controller for booking service
 * mapping the request path
 * @author: Huayu Zhang
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     *
     * @param bkID booking ID
     * @return the queried booking object
     * @author: Huayu Zhang
     */
    @GetMapping("/{bkID}")
    public Booking queryByBookingByPatientAndDoctorID(@PathVariable("bkID") Long bkID) {
        return bookingService.queryBookingById(bkID);
    }
}
