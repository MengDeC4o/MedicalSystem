package com.se.hospitalmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_drug")
public class Drug {
    @Id
    @Column(name = "drug_id")
    private int drug_id;
    @Column(name = "drug_name")
    private String drug_name;
    @Column(name = "drug_producer")
    private String drug_producer;
    @Column(name = "drug_produceDate")
    private String drug_produceDate;
    @Column(name = "drug_expdate")
    private String drug_expdate;
    @Column(name = "stock")
    private int stock;
    @Column(name = "drug_abstract")
    private String drug_abstract;
    @Column(name = "drug_description")
    private String drug_description;
    @Column(name = "comm")
    private String comm;

    public Drug(String drug_name, String drug_producer, String drug_produceDate, String drug_expdate, int stock, String drug_abstract, String drug_description, String comm)
    {
        this.drug_name=drug_name;
        this.drug_producer=drug_producer;
        this.drug_produceDate=drug_produceDate;
        this.drug_expdate=drug_expdate;
        this.stock=stock;
        this.drug_abstract = drug_abstract;
        this.drug_description = drug_description;
        this.comm=comm;
    }

    public Drug(String drug_name) {
        this.drug_name=drug_name;
        this.stock=1;
    }
  
    public Drug(String drug_name, String drug_abstract, String drug_description, String comm)
    {
        this.drug_name=drug_name;
        this.drug_abstract = drug_abstract;
        this.drug_description = drug_description;
    }
}
