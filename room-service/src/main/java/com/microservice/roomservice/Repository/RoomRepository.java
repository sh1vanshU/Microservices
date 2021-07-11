package com.microservice.roomservice.Repository;

import com.microservice.roomservice.Model.Room;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,Long>{
    
}
