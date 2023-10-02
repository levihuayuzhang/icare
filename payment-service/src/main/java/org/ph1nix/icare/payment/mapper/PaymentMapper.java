package org.ph1nix.icare.payment.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ph1nix.icare.payment.pojo.Payment;

public interface PaymentMapper {
    /**
     * query the payment from database using SQL statement with parameter of doctor ID
     *
     * @param pmID Payment ID
     * @return payment object
     * @author Huayu Zhang
     */
    @Select("select * from tb_payment where pmID = #{pmID}")
    Payment findById(@Param("pmID") Long pmID);
}
