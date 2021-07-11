package com.microservice.guestservice.Controller;

import com.microservice.guestservice.Model.Guest;
import com.microservice.guestservice.Repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestWebService_Controller {

    @Autowired
    private final GuestRepository guestRepository;

    public GuestWebService_Controller(GuestRepository guestRepository) {
        super();
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public Iterable<Guest> getAllGuests() {
        return this.guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id") long id) {
        return this.guestRepository.findById(id).get();
    }

}
