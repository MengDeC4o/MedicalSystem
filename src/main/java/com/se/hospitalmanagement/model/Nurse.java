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
@Table(name = "t_nurse")

public class Nurse{
    @Id
    @Column(name = "nurse_id")
    private int nurse_id;
    @Column(name = "nurse_name")
    private String nurse_name;
    @Column(name = "nurse_major")
    private String nurse_major;
    @Column(name = "nurse_department")
    private String nurse_department;
    @Column(name = "nurse_level")
    private String nurse_level;
    @Column(name = "nurse_description")
    private String nurse_description;
    @Column(name = "nurse_experience")
    private int nurse_experience;
    @Column(name = "nurse_account_id")
    private String nurse_account_id;
    @Column(name = "nurse_account_password")
    private String nurse_account_password;

    public Nurse(String nurse_name, String nurse_major, String nurse_department, String nurse_level, String nurse_description, int nurse_experience, String nurse_account_id, String nurse_account_password)
    {
        this.nurse_name=nurse_name;
        this.nurse_major=nurse_major;
        this.nurse_department=nurse_department;
        this.nurse_level=nurse_level;
        this.nurse_description=nurse_description;
        this.nurse_experience=nurse_experience;
        this.nurse_account_id=nurse_account_id;
        this.nurse_account_password=nurse_account_password;
    }

}
