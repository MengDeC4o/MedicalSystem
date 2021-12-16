package com.se.hospitalmanagement.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.se.hospitalmanagement.mapper.*;
import com.se.hospitalmanagement.model.*;
import com.se.hospitalmanagement.util.DateTimeUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Drug")
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true",allowedHeaders = {"X-Custom-Header"}, maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class DrugManagement {
    @Autowired(required = false)
    private DrugMapper drugMapper;

    @RequestMapping(value = "/stock_change1")
    public Map<String, Object> stock_change1(@RequestParam("new_stock") int new_stock, @RequestParam("drug_id") int drug_id)
    {
        Map<String, Object> map = new HashMap<>();
        if (drugMapper.countByDrugID(drug_id)==0)
        {
            map.put("failure", "no such drug in record!");
        }
        else
        {
            drugMapper.Update_StockbyID(new_stock,drug_id);
            map.put("result","success!");
        }
        return map;
    }
    @RequestMapping(value = "/stock_change2")
    public Map<String, Object> stock_change2(@RequestParam("new_stock") int new_stock, @RequestParam("drug_name") String drug_name)
    {
        Map<String, Object> map = new HashMap<>();
        if (drugMapper.countByDrugName(drug_name)==0)
        {
            map.put("failure", "no such drug in record!");
        }
        else
        {
            drugMapper.Update_StockbyName(new_stock,drug_name);
            map.put("result","success!");
        }
        return map;
    }

    @RequestMapping(value = "/stock_search1")
    public Map<String, Object> stock_search1(@RequestParam("drug_id") int drug_id)
    {
        Map<String, Object> map = new HashMap<>();
        if (drugMapper.countByDrugID(drug_id)==0)
        {
            map.put("failure", "no such drug in record!");
        }
        else
        {
            Drug printed = drugMapper.selectByDrugId(drug_id);
            map.put("stock",printed.getStock());
        }
        return map;
    }
    @RequestMapping(value = "/stock_search2")
    public Map<String, Object> stock_search2(@RequestParam("drug_name") String drug_name)
    {
        Map<String, Object> map = new HashMap<>();
        if (drugMapper.countByDrugName(drug_name)==0)
        {
            map.put("failure", "no such drug in record!");
        }
        else
        {
            Drug printed = drugMapper.selectByDrugName(drug_name);
            map.put("stock",printed.getStock());
        }

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "insert_newDrug")
    public Map<String, Object> insert_newDrug( String drug_name,  Integer amount)
    {

        System.out.println("Insert New Drug");
        Map<String, Object> map = new HashMap<>();
        if(drug_name == null || amount == null){
            System.out.println("Some parameter is wrong");
            System.out.println(drug_name);
            System.out.println(amount);
            map.put("nullpointer", "some parameter is wrong");
            return map;
        }
        System.out.println(amount);
        if (drugMapper.countByDrugName(drug_name)>0) // if Drug already exists in the database
        {
            Drug selected_drug = drugMapper.selectByDrugName(drug_name);
            int new_stock = selected_drug.getStock()+amount;
            drugMapper.Update_StockbyName(new_stock,drug_name);
            map.put("result","already exist, increment!");
        }
        else
        {
            drugMapper.insert(new Drug(drug_name,amount ));
            map.put("result","successful insertion!");
        }

        return map;
    }

    @RequestMapping(value = "/getAllDrugs")
    public Map<String,Object> getAllPatients(){
        Map<String,Object> map=new HashMap<>();
        //PageHelper.startPage(currentPage,10);
        List<Drug> list=drugMapper.selectAllDrugs();
        //PageInfo<Patient> pageInfo=new PageInfo<>(list);
        //map.put("pageInfo",pageInfo);
        map.put("list",list);
        return map;
    }
}
