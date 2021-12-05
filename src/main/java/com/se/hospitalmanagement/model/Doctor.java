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
@Table(name = "t_doctor")

public class Doctor {
    @Id
    @Column(name = "doctor_id")
    private int doctor_id;
    @Column(name = "doctor_name")
    private String doctor_name;
    @Column(name = "doctor_age")
    private int doctor_age;
    @Column(name = "doctor_major")
    private String doctor_major;
    @Column(name = "doctor_department")
    private String doctor_department;
    @Column(name = "doctor_level")
    private String doctor_level;
    @Column(name = "doctor_description")
    private String doctor_description;
    @Column(name = "doctor_experience")
    private int doctor_experience;
    @Column(name = "doctor_account_id")
    private String doctor_account_id;
    @Column(name = "doctor_account_password")
    private String doctor_account_password;

    public Doctor(String doctor_name, int doctor_age, String doctor_major, String doctor_department, String doctor_level, String doctor_description, int doctor_experience, String doctor_account_id, String doctor_account_password)
    {
        this.doctor_name=doctor_name;
        this.doctor_age=doctor_age;
        this.doctor_major=doctor_major;
        this.doctor_department=doctor_department;
        this.doctor_level=doctor_level;
        this.doctor_description=doctor_description;
        this.doctor_experience=doctor_experience;
        this.doctor_account_id=doctor_account_id;
        this.doctor_account_password=doctor_account_password;
    }

}
