package com.se.hospitalmanagement.mapper;

import com.se.hospitalmanagement.model.*;
import com.se.hospitalmanagement.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomMapper extends MyMapper<Patient> {
    /**
     * select a room in database by room_Id
     **/
    @Select("select * from t_room where room_id=#{room_id}")
    @Results({
            @Result(id = true, column = "room_id", property = "room_id"),
            @Result(column = "room_function", property = "room_function"),
    })
    Room selectByRoomId(@Param("room_id") int room_id);

    /* select all rooms with a particular function */
    @Select("select * from t_room where room_function=#{room_function}")
    @Results({
            @Result(id = true, column = "room_id", property = "room_id"),
            @Result(column = "room_function", property = "room_function"),
    })
    List<Room> selectByRoomFunction(@Param("room_function") String room_function);

    @Select("select * from t_room")
    @Results({
            @Result(column = "room_id", property = "room_id"),
            @Result(column = "room_function", property = "room_function"),
            @Result(column = "current_doctor", property = "current_doctor"),
            @Result(column = "current_patientNum", property = "current_patientNum"),
    })
    List<Room> selectAllRooms();

}
