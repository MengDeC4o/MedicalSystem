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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Patient")
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true",allowedHeaders = {"X-Custom-Header"}, maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class PatientManagement {
    @Autowired(required = false)
    private PatientMapper patientMapper;

    @RequestMapping(value = "/getAllPatients")
    public Map<String,Object> getAllPatients(){
        Map<String,Object> map=new HashMap<>();
        //PageHelper.startPage(currentPage,10);
        List<Patient> list=patientMapper.selectAllPatients();
        //PageInfo<Patient> pageInfo=new PageInfo<>(list);
        //map.put("pageInfo",pageInfo);
        map.put("patients",list);
        return map;
    }


    @RequestMapping(value = "/patient_id_search")
    public Map<String,Object> patient_name_search_by_name(@RequestParam("patient_name")String patient_name)
    {
        Map<String,Object> map=new HashMap<>();
        Patient printed = patientMapper.selectByPatientName(patient_name);
        map.put("id",printed.getPatient_id());
        return map;
    }

    @RequestMapping(value = "/patient_search_by_accountID")
    public Map<String,Object> patient_search_by_accountID(@RequestParam("patient_account_id")String patient_account_id)
    {
        Map<String,Object> map=new HashMap<>();
        Patient printed = patientMapper.selectByPatientAccount(patient_account_id);
        map.put("id",printed);
        return map;
    }

    @RequestMapping(value = "/patient_search_by_patient_id")
    public Map<String,Object> patient_search_by_patient_id(@RequestParam("patient_id")int patient_id)
    {
        Map<String,Object> map=new HashMap<>();
        Patient printed = patientMapper.selectByPatientId(patient_id);
        map.put("patient",printed);
        return map;
    }


}

