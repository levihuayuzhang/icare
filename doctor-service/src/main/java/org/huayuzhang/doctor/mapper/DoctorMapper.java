package org.huayuzhang.doctor.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.huayuzhang.doctor.pojo.Doctor;


public interface DoctorMapper {
    @Select("select * from tb_doctor where id = #{id}")
    Doctor findById(@Param("id") Long id);
}