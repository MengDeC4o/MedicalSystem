package com.se.hospitalmanagement.mapper;
import com.se.hospitalmanagement.model.Drug;
import com.se.hospitalmanagement.model.Nurse;
import com.se.hospitalmanagement.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface NurseMapper extends MyMapper<Nurse> {
    /** select a nurse in database by nurse_Id **/
    @Select("select * from t_nurse where nurse_id=#{nurse_id}")
    @Results({
            @Result(id = true, column = "nurse_id", property = "nurse_id"),
            @Result(column = "nurse_name", property = "nurse_name"),
            @Result(column = "nurse_major", property = "nurse_major"),
            @Result(column = "nurse_department", property = "nurse_department"),
            @Result(column = "nurse_level", property = "nurse_level"),
            @Result(column = "nurse_description", property = "nurse_description"),
            @Result(column = "nurse_experience", property = "nurse_experience"),
            @Result(column = "nurse_account_id", property = "nurse_account_id"),
            @Result(column = "nurse_account_password", property = "nurse_account_password")
    })
    Nurse selectByNurseId(@Param("nurse_id") int nurse_id);

    /** check whether the searched account is a nurse **/
    @Select("select count(*) from t_nurse where nurse_account_id=#{nurse_account_id}")
    int countByNurseAccountID(@Param("nurse_account_id") String nurse_account_id);

    /** return the password of a given doctor_account_id **/
    @Select("select nurse_account_password from t_nurse where nurse_account_id=#{nurse_account_id}")
    String searchPasswordByNurseAccountID(@Param("nurse_account_id") String nurse_account_id);
}
