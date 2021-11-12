package com.se.hospitalmanagement.controller;

import com.se.hospitalmanagement.mapper.DrugMapper;
import com.se.hospitalmanagement.mapper.PatientMapper;
import com.se.hospitalmanagement.model.Drug;
import com.se.hospitalmanagement.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drug")
public class Controller {
    @Autowired(required = false)
    private PatientMapper patientMapper;
    @Autowired(required = false)
    private DrugMapper drugMapper;

    @GetMapping(value = "/greet")
    public String greet(){
        return "This is the Medical Resource System.";
    }

    @RequestMapping(value = "/getAllPatients")
    public Map<String,Object> getAllPatients(){
        Map<String,Object> map=new HashMap<>();
        //PageHelper.startPage(currentPage,10);
        List<Patient> list=patientMapper.selectAllPatients();
        //PageInfo<Patient> pageInfo=new PageInfo<>(list);
        //map.put("pageInfo",pageInfo);
        map.put("albums",list);
        return map;
    }

    @RequestMapping(value = "/getAllDrugs")
    public Map<String,Object> getAllDrugs(){
        Map<String,Object> map = new HashMap<>();
        //PageHelper.startPage(currentPage,10);
        List<Drug> list = drugMapper.selectAllDrugs();
        //PageInfo<Patient> pageInfo=new PageInfo<>(list);
        //map.put("pageInfo",pageInfo);
        map.put("albums",list);
        return map;
    }

    @RequestMapping(value = "/search_by_patient_name")
    public Map<String,Object> patient_name_search(@RequestParam("patient_id")int patient_id)
    {
        Map<String,Object> map=new HashMap<>();
        Patient printed = patientMapper.selectByPatientId(patient_id);
        map.put("name",printed.getPatient_name());
        return map;
    }

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

    @RequestMapping(value = "/insert_newDrug")
    public Map<String, Object> insert_newDrug(@RequestParam("drug_name")  String drug_name)
    {
        Map<String, Object> map = new HashMap<>();
        drugMapper.insert(new Drug(drug_name));
        map.put("result","success!");
        return map;
    }
}

