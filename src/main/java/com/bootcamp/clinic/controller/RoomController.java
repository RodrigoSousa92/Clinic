package com.bootcamp.clinic.controller;

import com.bootcamp.clinic.model.Room;
import com.bootcamp.clinic.request.RoomCreationRQ;
import com.bootcamp.clinic.request.UpdateRoomNumberRQ;
import com.bootcamp.clinic.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class RoomController {
    @Autowired
    RoomService roomService;

    //Get all rooms
    @GetMapping("/Rooms")
    public List<Room> getRooms() {
        return roomService.findAll();
    }

    //Get rooms by id
    @GetMapping("/Room/{id}")
    public Room getRoomsById(@PathVariable Long id) {
        return roomService.getRoomsById(id);
    }

    //Create room
    @PostMapping(value = "/Rooms")
    public List<Room> createRooms(@RequestBody @Valid List<RoomCreationRQ> roomCreationRQS) {
        return roomService.createRooms(roomCreationRQS);
    }

    //Update room
    @PutMapping(value = "/Room-update/{id}")
    public Room updateRoomSchedule(@PathVariable(value = "id") Long id, @RequestBody UpdateRoomNumberRQ updateRoomNumberRQ) {
        return roomService.updateRoom(id, updateRoomNumberRQ.getNumber());
    }

    //Delete doctor
    @DeleteMapping(path = "/delete-room/{id}")
    public ResponseEntity deleteRoom(@PathVariable(value = "id") Long roomId) {
        roomService.deleteById(roomId);
        return ResponseEntity.created(URI.create("/room")).body("room removed");
    }
}