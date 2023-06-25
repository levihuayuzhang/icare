package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Patient;

public interface PatientMapper {
    @Select("select * from tb_patient where id = #{id}")
    Patient findById(@Param("id") Long id);
}