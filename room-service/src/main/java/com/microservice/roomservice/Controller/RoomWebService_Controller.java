package com.microservice.roomservice.Controller;

import com.microservice.roomservice.Model.Room;
import com.microservice.roomservice.Repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomWebService_Controller{

    @Autowired
    private RoomRepository roomRepository;

    public RoomWebService_Controller(RoomRepository repository){
        super();
        this.roomRepository=repository;
    }

    @GetMapping
    public Iterable<Room> getAllRooms(){
        return this.roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable(name = "id")long id){
        return this.roomRepository.findById(id).get();
    }
}