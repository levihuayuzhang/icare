package org.huayuzhang.payment.mapper;

import org.apache.ibatis.annotations.Select;
import org.huayuzhang.payment.pojo.Payment;

public interface PaymentMapper {
    @Select("select * from tb_payment where pmID = #{pmID}")
    Payment findById(Long bkID);
}
