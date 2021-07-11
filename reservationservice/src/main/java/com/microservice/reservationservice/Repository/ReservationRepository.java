package com.microservice.reservationservice.Repository;

import com.microservice.reservationservice.Model.Reservation;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
