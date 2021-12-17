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
@RequestMapping("/Queue")
public class QueueManagement {
    @Autowired(required = false)
    private DrugMapper drugMapper;
    @Autowired(required = false)
    private PatientMapper patientMapper;
    @Autowired(required = false)
    private RoomMapper roomMapper;

    Map<Integer,Room> roomlist;
    Map<Integer,Patient> patientlist;

    /* the algorithm to find the correct-functioned room with minimum patient */
    private int find_room(String operation)
    {
        int min=-1;
        int min_index=-1;
        for (Map.Entry<Integer,Room> entry : roomlist.entrySet())
        {
            if (entry.getValue().getRoom_function().equals(operation))
            {
                if (min==-1 || entry.getValue().getCurrent_patientNum()<min)
                {
                    min=entry.getValue().getCurrent_patientNum();
                    min_index= entry.getKey();
                }
            }

        }
        return min_index;
    }

    /* insert the patient to the corresponding queue after registration */
    @RequestMapping(value="/patient_registered")
    public Map<String,Object> patient_registered( int patient_id, String operation)
    {
        Map<String, Object> map = new HashMap<>();
        Patient patient = patientlist.get(patient_id);
        Room next_room = roomlist.get(find_room(operation));
        patient.getRoomQueue().addLast(next_room);
        patient.setRoomNumRemain(patient.getRoomNumRemain()+1);
        next_room.getPatientQueue().addLast(patient);
        next_room.setCurrent_patientNum(next_room.getCurrent_patientNum()+1);
        map.put("result: ","patient is added to the queue after registration!");
        return map;
    }

    /** when a doctor/nurse finishes the work on a particular patient, they call this function **/
    @RequestMapping(value="/patient_finish")
    public Map<String,Object> patient_finish(int patient_id, int room_id, String[] next_op)
    {
        Map<String, Object> map = new HashMap<>();
        Room current_room = roomlist.get(room_id);
        Patient removed = current_room.getPatientQueue().removeLast();
        current_room.setCurrent_patientNum(current_room.getCurrent_patientNum()-1);
        removed.setRoomNumRemain(removed.getRoomNumRemain()-1);
        removed.getRoomQueue().removeLast();// the patient leave the current room
        if (next_op.length!=0) { // according to the instruction from the doctor, add patient to queues
            for (int i=0;i<next_op.length;i++)
            {
                Room next_room = roomlist.get(find_room(next_op[i]));
                removed.getRoomQueue().addLast(next_room);
                removed.setRoomNumRemain(removed.getRoomNumRemain()+1);
                next_room.getPatientQueue().addLast(removed);
                next_room.setCurrent_patientNum(next_room.getCurrent_patientNum()+1);
                map.put("success", "next operations successfully inserted");
            }

        }
        else
        {
            map.put("result:","the patient can leave!");
        }
        return map;
    }

    @RequestMapping(value="/room_init")
    public Map<String,Object> room_init()
    {
        Map<String, Object> map = new HashMap<>();
        roomlist=new HashMap<>();
        List<Room> room_list = roomMapper.selectAllRooms();
        for (int i=0;i<room_list.size();i++)
        {
            LinkedList<Patient> added = new LinkedList<Patient>();
            room_list.get(i).setPatientQueue(added);
            roomlist.put(room_list.get(i).getRoom_id(),room_list.get(i));
        }
        map.put("result: ","successful initialization!");
        return map;
    }
    @RequestMapping(value="/patient_init")
    public Map<String,Object> patient_init()
    {
        Map<String, Object> map = new HashMap<>();
        patientlist=new HashMap<>();
        List<Patient> patient_list = patientMapper.selectAllPatients();
        for (int i=0;i<patient_list.size();i++)
        {
            LinkedList<Room> added = new LinkedList<Room>();
            patient_list.get(i).setRoomQueue(added);
            patientlist.put(patient_list.get(i).getPatient_id(),patient_list.get(i));
        }
        map.put("result: ","successful initialization!");
        return map;
    }

    @RequestMapping(value="/patient_register")
    public Map<String,Object> patient_register( String patient_account_id)
    {
        Map<String, Object> map = new HashMap<>();
        if (patientMapper.countByPatientAccountID(patient_account_id)==0)
        {
            map.put("error: ", "patient not found!");
        }
        else
        {
            int p_id = patientMapper.selectByPatientAccount(patient_account_id).getPatient_id();
            if (patientlist.containsKey(p_id))
            {
                map.put("success: ", "patient already registered!");
                return map;
            }
            patientlist.put(p_id,patientMapper.selectByPatientAccount(patient_account_id));
            patientlist.get(p_id).setRoomQueue(new LinkedList<Room>());
            map.put("success: ","patient registered!");
        }
        return map;
    }

    @RequestMapping(value="/init")
    public Map<String,Object> init()
    {
        Map<String, Object> map = new HashMap<>();
        room_init();
        patientlist=new HashMap<>();
        return map;
    }

    @RequestMapping(value="/view_room_queue")
    public Map<String,Object> view_room_queue(String patient_account_id)
    {
        Map<String, Object> map = new HashMap<>();
        int temp_id = patientMapper.selectByPatientAccount(patient_account_id).getPatient_id();
        LinkedList<Integer> returned=new LinkedList<Integer>();
        LinkedList<Room> temp_roomQueue = patientlist.get(temp_id).getRoomQueue();
        for (int i=0;i< temp_roomQueue.size();i++)
        {
            returned.addLast(temp_roomQueue.get(i).getRoom_id());
        }
        map.put("room_queue: ", returned);
        return map;
    }

    @RequestMapping(value="/view_patient_queue")
    public Map<String,Object> view_patient_queue(int room_id)
    {
        Map<String, Object> map = new HashMap<>();
        LinkedList<String> returned=new LinkedList<String>();
        LinkedList<Patient> temp_patientQueue = roomlist.get(room_id).getPatientQueue();
        for (int i=0;i< temp_patientQueue.size();i++)
        {
            returned.addLast(temp_patientQueue.get(i).getPatient_account_id());
        }
        map.put("patient_queue: ", returned);
        return map;
    }
}
