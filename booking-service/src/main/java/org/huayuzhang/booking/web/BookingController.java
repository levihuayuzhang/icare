package org.huayuzhang.booking.web;

import lombok.extern.slf4j.Slf4j;
import org.huayuzhang.booking.pojo.Booking;
import org.huayuzhang.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/{bkID}")
    public Booking queryByID(@PathVariable("bkID") Long bkID) {
        return bookingService.queryById(bkID);
    }
}
