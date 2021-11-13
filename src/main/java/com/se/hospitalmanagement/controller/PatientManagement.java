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
@RequestMapping("/Patient")
public class PatientManagement {
    @Autowired(required = false)
    private PatientMapper patientMapper;
    
    @RequestMapping(value = "/patient_name_search")
    public Map<String,Object> patient_name_search(@RequestParam("patient_id")int patient_id)
    {
        Map<String,Object> map=new HashMap<>();
        Patient printed = patientMapper.selectByPatientId(patient_id);
        map.put("name",printed.getPatient_name());
        return map;
    }
}

