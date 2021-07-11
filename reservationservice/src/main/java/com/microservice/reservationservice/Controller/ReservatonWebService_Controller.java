package com.microservice.reservationservice.Controller;

import com.microservice.reservationservice.Model.Reservation;
import com.microservice.reservationservice.Repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservatonWebService_Controller {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public ReservatonWebService_Controller(ReservationRepository repository)
    {
        super();
        this.reservationRepository=repository;
    }

    @GetMapping
    public Iterable<Reservation> getAllReservation(){
        return this.reservationRepository.findAll();
    } 

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable(name = "id")long id)
    {
        return this.reservationRepository.findById(id).get();
    }

}
