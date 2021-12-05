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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserManagement {
    @Autowired(required = false)
    private DoctorMapper doctorMapper;
    @Autowired(required = false)
    private NurseMapper nurseMapper;
    @Autowired(required = false)
    private PatientMapper patientMapper;

    /** login **/
    @RequestMapping("/login")
    public Map<String,Object> login(@RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("status") String status)
    {
        Map<String, Object> map = new HashMap<>();
        if (status.equals("patient"))
        {
            if (patientMapper.countByPatientAccountID(account)==0)
            {
                map.put("failure","account not found!");

            }
            else
            {
                String correct_password= patientMapper.searchPasswordByPatientAccountID(account);
                if (correct_password.equals(password))
                {
                    map.put("success","login status: patient");
                }
                else
                {
                    map.put("failure","wrong password!");
                }
            }
        }
        else if (status.equals("doctor"))
        {
            if (doctorMapper==null)
            {
                return map;
            }
            if (doctorMapper.countByDoctorAccountID(account)==0)
            {
                map.put("failure","account not found!");
            }
            else
            {
                String correct_password= doctorMapper.searchPasswordByDoctorAccountID(account);
                if (correct_password.equals(password))
                {
                    map.put("success","login status: doctor");
                }
                else
                {
                    map.put("failure","wrong password!");
                }
            }
        }
        else  if (status.equals("nurse"))
        {
            if (nurseMapper.countByNurseAccountID(account)==0)
            {
                map.put("failure: ","account not found!");
            }
            else
            {
                String correct_password= nurseMapper.searchPasswordByNurseAccountID(account);
                if (correct_password.equals(password))
                {
                    map.put("success","login status: nurse");
                }
                else
                {
                    map.put("failure","wrong password!");
                }
            }
        }
        else if (status.equals("guest"))
        {
            map.put("success", "login status: guest");
        }
        return map;
    }

    /** only patients are allowed to register new account **/
    @RequestMapping("/account_register")
    public Map<String,Object> account_register(@RequestParam("account") String account, @RequestParam("password") String password)
    {
        Map<String,Object> map = new HashMap<>();
        if (patientMapper.countByPatientAccountID(account)!=0) // if the account id is already existed
        {
            map.put("error","account already exists!");
        }
        else
        {
            patientMapper.insert(new Patient(account,password));
            map.put("success","account successfully created!");
        }
        return map;
    }



}
