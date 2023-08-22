package org.huayuzhang.patient.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.huayuzhang.patient.pojo.Patient;

public interface PatientMapper {
    /**
     * query the doctor from database using SQL statement with parameter of patient ID
     *
     * @param id Patient ID
     * @return Patient object
     * @author Huayu Zhang
     */
    @Select("select * from tb_patient where id = #{id}")
    Patient findById(@Param("id") Long id);
}