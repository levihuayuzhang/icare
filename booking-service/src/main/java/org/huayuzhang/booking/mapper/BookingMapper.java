package org.huayuzhang.booking.mapper;

import org.huayuzhang.booking.pojo.Booking;
import org.apache.ibatis.annotations.Select;

public interface BookingMapper {
    @Select("select * from tb_order where id = #{id}")
    Booking findById(Long id);
}
