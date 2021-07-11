package com.microservice.guestservice.Repository;

import com.microservice.guestservice.Model.Guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

}
