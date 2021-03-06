package com.se.hospitalmanagement.mapper;

import com.se.hospitalmanagement.model.Patient;
import com.se.hospitalmanagement.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientMapper extends MyMapper<Patient> {
     /** select a single patient in database by patient_Id **/
    @Select("select * from t_patient where patient_id=#{patient_id}")
    @Results({
            @Result(id = true, column = "patient_id", property = "patient_id"),
            @Result(column = "patient_name", property = "patient_name"),
            @Result(column = "patient_age", property = "patient_age"),
            @Result(column = "patient_iden_id", property = "patient_iden_id"),
            @Result(column = "last_hospitalizationTime", property = "last_hospitalizationTime"),
            @Result(column = "patient_sex", property = "patient_sex"),
            @Result(column = "disease", property = "disease"),
            @Result(column = "patient_account_id", property = "patient_account_id"),
            @Result(column = "patient_account_password", property = "patient_account_password")
    })
    Patient selectByPatientId(@Param("patient_id") int patient_id);

    /** select a single patient in database by patient_Id **/
    @Select("select * from t_patient where patient_name=#{patient_name}")
    @Results({
            @Result(id = true, column = "patient_id", property = "patient_id"),
            @Result(column = "patient_name", property = "patient_name"),
            @Result(column = "patient_age", property = "patient_age"),
            @Result(column = "patient_iden_id", property = "patient_iden_id"),
            @Result(column = "last_hospitalizationTime", property = "last_hospitalizationTime"),
            @Result(column = "patient_sex", property = "patient_sex"),
            @Result(column = "disease", property = "disease"),
            @Result(column = "patient_account_id", property = "patient_account_id"),
            @Result(column = "patient_account_password", property = "patient_account_password")
    })
    Patient selectByPatientName(@Param("patient_name") String patient_name);

    /** select a single patient in database by patient_account_Id **/
    @Select("select * from t_patient where patient_account_id=#{patient_account_id}")
    @Results({
            @Result(id = true, column = "patient_id", property = "patient_id"),
            @Result(column = "patient_name", property = "patient_name"),
            @Result(column = "patient_age", property = "patient_age"),
            @Result(column = "patient_iden_id", property = "patient_iden_id"),
            @Result(column = "last_hospitalizationTime", property = "last_hospitalizationTime"),
            @Result(column = "patient_sex", property = "patient_sex"),
            @Result(column = "disease", property = "disease"),
            @Result(column = "patient_account_id", property = "patient_account_id"),
            @Result(column = "patient_account_password", property = "patient_account_password")
    })
    Patient selectByPatientAccount(@Param("patient_account_id") String patient_account_id);
    /** get all patients in database **/

    @Select("select * from t_patient")
    @Results({
            @Result(column = "patient_id", property = "patient_id"),
            @Result(column = "patient_name", property = "patient_name"),
            @Result(column = "patient_age", property = "patient_age"),
            @Result(column = "patient_iden_id", property = "patient_iden_id"),
            @Result(column = "last_hospitalizationTime", property = "last_hospitalizationTime"),
            @Result(column = "patient_sex", property = "patient_sex"),
            @Result(column = "disease", property = "disease"),
            @Result(column = "patient_account_id", property = "patient_account_id"),
            @Result(column = "patient_account_password", property = "patient_account_password")
    })
    List<Patient> selectAllPatients();


    /** update a patient's disease **/
    @Update("update t_patient set disease=#{disease} where patient_id=#{patient_id}")
    void Update_diseaseByID(@Param("disease") String disease, @Param("patient_id") int patient_id);

    /** check whether the searched account is a patient **/
    @Select("select count(*) from t_patient where patient_account_id=#{patient_account_id}")
    int countByPatientAccountID(@Param("patient_account_id") String patient_account_id);

    /** return the password of a given patient_account_id **/
    @Select("select patient_account_password from t_patient where patient_account_id=#{patient_account_id}")
    String searchPasswordByPatientAccountID(@Param("patient_account_id") String patient_account_id);

}
