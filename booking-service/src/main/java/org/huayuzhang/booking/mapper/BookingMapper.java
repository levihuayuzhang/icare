package org.huayuzhang.booking.mapper;

import org.huayuzhang.booking.pojo.Booking;
import org.apache.ibatis.annotations.Select;

public interface BookingMapper {
    @Select("select * from tb_booking where bkID = #{bkID}")
    Booking findById(Long bkID);
}
