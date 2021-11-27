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
@Table(name = "t_room")
public class Room {
    @Id
    @Column(name = "room_id")
    private int room_id;
    @Column(name = "room_function")
    private String room_function;
    @Transient
    private String current_doctor;
    @Transient
    private String current_nurse;
    @Transient
    private int current_patientNum;
    @Transient
    private LinkedList<Patient> PatientQueue;

    public Room(String room_function)
    {
        this.room_function=room_function;
        this.current_doctor="No doctor";
        this.current_nurse="No nurse";
        this.current_patientNum=0;
        this.PatientQueue = new LinkedList<Patient>();
    }

}
