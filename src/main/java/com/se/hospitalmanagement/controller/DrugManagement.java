package com.se.hospitalmanagement.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.se.hospitalmanagement.mapper.*;
import com.se.hospitalmanagement.model.*;
import com.se.hospitalmanagement.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Drug")
public class DrugManagement {
    @Autowired(required = false)
    private DrugMapper drugMapper;

    @RequestMapping(value = "/stock_change")
    public Map<String, Object> stock_change(@RequestParam("new_stock") int new_stock, @RequestParam("drug_id") int drug_id)
    {
        Map<String, Object> map = new HashMap<>();
        drugMapper.Update_Stock(new_stock,drug_id);
        map.put("result","success!");
        return map;
    }

    @RequestMapping(value = "/stock_search")
    public Map<String, Object> stock_search(@RequestParam("drug_id") int drug_id)
    {
        Map<String, Object> map = new HashMap<>();
        Drug printed = drugMapper.selectByDrugId(drug_id);
        map.put("stock",printed.getStock());
        return map;
    }

    @RequestMapping(value = "insert_newDrug")
    public Map<String, Object> insert_newDrug(@RequestParam("drug_name")  String drug_name)
    {
        Map<String, Object> map = new HashMap<>();
        if (drugMapper.countByDrugName(drug_name)>0) // if Drug already exists in the database
        {
            Drug selected_drug = drugMapper.selectByDrugName(drug_name);
            int new_stock = selected_drug.getStock()+1;
            int d_id = selected_drug.getDrug_id();

            drugMapper.Update_Stock(new_stock,d_id);
            map.put("result","already exist, increment!");
        }
        else
        {
            drugMapper.insert(new Drug(drug_name));
            map.put("result","successful insertion!");
        }

        return map;
    }


    @RequestMapping(value = "/getAllDrugs")
    public Map<String,Object> getAllDrugs(){
        Map<String,Object> map=new HashMap<>();
        //PageHelper.startPage(currentPage,10);
        List<Drug> list= drugMapper.selectAllDrugs();
        //PageInfo<Patient> pageInfo=new PageInfo<>(list);
        //map.put("pageInfo",pageInfo);
        map.put("drugs",list);
        return map;
    }
}
