package org.huayuzhang.booking.service;

import org.huayuzhang.booking.mapper.BookingMapper;
import org.huayuzhang.booking.pojo.Booking;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingService {
    @Autowired
    private BookingMapper bookingMapper;

    public Booking queryById(Long bkID) {
        return bookingMapper.findById(bkID);
    }
}
