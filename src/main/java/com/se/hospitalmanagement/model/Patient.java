package com.se.hospitalmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.LinkedList;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_patient")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private int patient_id;
    @Column(name = "patient_name")
    private String patient_name;
    @Column(name = "patient_age")
    private int patient_age;
    @Column(name = "patient_iden_id")
    private String patient_iden_id;
    @Column(name = "last_hospitalizationTime")
    private String last_hospitalizationTime;
    @Column(name = "patient_sex")
    private String patient_sex;
    @Column(name = "disease")
    private String disease;
    @Column(name = "patient_account_id")
    private String patient_account_id;
    @Column(name = "patient_account_password")
    private String patient_account_password;
    @Transient
    private LinkedList<Room> roomQueue;
    @Transient
    private int roomNumRemain;

    public Patient(String patient_name, int patient_age, String patient_iden_id, String last_hospitalizationTime, String patient_sex, String disease, String patient_account_id, String patient_account_password)
    {
        this.patient_name=patient_name;
        this.patient_age=patient_age;
        this.patient_iden_id=patient_iden_id;
        this.last_hospitalizationTime=last_hospitalizationTime;
        this.patient_sex=patient_sex;
        this.disease=disease;
        this.patient_account_id=patient_account_id;
        this.patient_account_password=patient_account_password;
        this.roomQueue=new LinkedList<Room>();
        this.roomNumRemain=0;
    }

    public Patient(String patient_account_id, String disease)
    {
        this.patient_account_id=patient_account_id;
        this.disease=disease;
        this.roomQueue=new LinkedList<Room>();
        this.roomNumRemain=0;
    }


}
