package com.se.hospitalmanagement.mapper;


import org.apache.ibatis.annotations.*;
import com.se.hospitalmanagement.util.MyMapper;
import com.se.hospitalmanagement.model.Drug;

import java.util.List;

@Mapper
public interface DrugMapper extends MyMapper<Drug> {

    /** select a single type of drug in database by drug_Id **/
    @Select("select * from t_drug where drug_id=#{drug_id}")
    @Results({
            @Result(id = true, column = "drug_id", property = "drug_id"),
            @Result(column = "drug_name", property = "drug_name"),
            @Result(column = "drug_producer", property = "drug_producer"),
            @Result(column = "drug_produceDate", property = "drug_produceDate"),
            @Result(column = "drug_expdate", property = "drug_expdate"),
            @Result(column = "stock", property = "stock"),
            @Result(column = "treat_disease", property = "treat_disease"),
            @Result(column = "commen", property = "commen")
    })
    Drug selectByDrugId(@Param("drug_id") int drug_id);

    /** get all drugs in database **/

    @Select("select * from t_drug")
    @Results({
            @Result(column = "drug_id", property = "drug_id"),
            @Result(column = "drug_name", property = "drug_name"),
            @Result(column = "drug_producer", property = "drug_producer"),
            @Result(column = "drug_produceDate", property = "drug_produceDate"),
            @Result(column = "drug_expdate", property = "drug_expdate"),
            @Result(column = "stock", property = "stock"),
            @Result(column = "treat_disease", property = "treat_disease"),
            @Result(column = "commen", property = "commen")
    })
    List<Drug> selectAllDrugs();


    /** change the stock number of a particular drug **/
    @Update("update t_drug set stock=#{new_stock} where drug_id=#{drug_id}")
    int Update_Stock(@Param("new_stock") int new_stock, @Param("drug_id") int drug_id);

}
