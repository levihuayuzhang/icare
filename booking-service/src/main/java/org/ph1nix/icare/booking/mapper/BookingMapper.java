/**
 * @name: BookingMapper
 * @author: Huayu Zhang
 * @date: 2023-07-03 16:28
 * @since: 1.0.0
 */

package org.ph1nix.icare.booking.mapper;

import org.apache.ibatis.annotations.Param;
import org.ph1nix.icare.booking.pojo.Booking;
import org.apache.ibatis.annotations.Select;

/**
 * The mapper for Booking service
 *
 * @author Huayu Zhang
 * @since JDK 1.8
 */
public interface BookingMapper {
    /**
     *
     * @param bkID booking ID
     * @return the queried data from SQL statement
     */
    @Select("select * from tb_booking where bkID = #{bkID}")
    Booking findById(@Param("bkID") Long bkID);
}
