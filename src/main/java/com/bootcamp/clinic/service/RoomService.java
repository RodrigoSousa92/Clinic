package com.bootcamp.clinic.service;

import com.bootcamp.clinic.exception.RoomNotFound;
import com.bootcamp.clinic.model.Room;
import com.bootcamp.clinic.repository.RoomRepository;
import com.bootcamp.clinic.request.RoomCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //Find all rooms
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    //Find by Id
    public Room getRoomsById(Long id) {
        return roomRepository.findById(id).orElseThrow(RoomNotFound::new);
    }


    //Create new rooms (List)
    public List<Room> createRooms(List<RoomCreationRQ> roomCreationRQList) {
        List<Room> newRoomList = new ArrayList<>();
        Room newRoom;
        for (RoomCreationRQ roomCreationRQ : roomCreationRQList) {
            newRoom = Room.builder().number(roomCreationRQ.getNumber()).build();
            roomRepository.save(newRoom);
            newRoomList.add(newRoom);
        }
        return newRoomList;
    }

    //Update room's by numbers
    public Room updateRoom(Long id, int number) {
        Room roomToUpdate = this.getRoomsById(id);
        roomToUpdate.setNumber(number);
        roomRepository.save(roomToUpdate);
        return roomToUpdate;
    }

    //Delete by id
    public void deleteById(Long id) {
        this.getRoomsById(id);
        roomRepository.deleteById(id);
    }
}