package com.se.hospitalmanagement.mapper;
import com.se.hospitalmanagement.model.Doctor;
import com.se.hospitalmanagement.model.Drug;
import com.se.hospitalmanagement.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface DoctorMapper extends MyMapper<Doctor> {
    /** select a doctor in database by doctor_Id **/
    @Select("select * from t_doctor where doctor_id=#{doctor_id}")
    @Results({
            @Result(id = true, column = "doctor_id", property = "doctor_id"),
            @Result(column = "doctor_name", property = "doctor_name"),
            @Result(column = "doctor_age", property = "doctor_age"),
            @Result(column = "doctor_major", property = "doctor_major"),
            @Result(column = "doctor_department", property = "doctor_department"),
            @Result(column = "doctor_level", property = "doctor_level"),
            @Result(column = "doctor_description", property = "doctor_description"),
            @Result(column = "doctor_experience", property = "doctor_experience"),
            @Result(column = "doctor_account_id", property = "doctor_account_id"),
            @Result(column = "doctor_account_password", property = "doctor_account_password")
    })
    Doctor selectByDoctorId(@Param("doctor_id") int doctor_id);

    /** check whether the searched account is a doctor **/
    @Select("select count(*) from t_doctor where doctor_account_id=#{doctor_account_id}")
    int countByDoctorAccountID(@Param("doctor_account_id") String doctor_account_id);

    /** return the password of a given doctor_account_id **/
    @Select("select doctor_account_password from t_doctor where doctor_account_id=#{doctor_account_id}")
    String searchPasswordByDoctorAccountID(@Param("doctor_account_id") String doctor_account_id);
}
