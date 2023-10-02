package org.ph1nix.icare.doctor.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ph1nix.icare.doctor.pojo.Doctor;


public interface DoctorMapper {
    /**
     * query the doctor from database using SQL statement with parameter of doctor ID
     *
     * @param id Doctor ID
     * @return doctor object
     * @author Huayu Zhang
     */
    @Select("select * from tb_doctor where id = #{id}")
    Doctor findById(@Param("id") Long id);
}