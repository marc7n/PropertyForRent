package com.marc7n.PropertyForRent.service;

import com.marc7n.PropertyForRent.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    List<Reservation> getReservations();


    Reservation create(Reservation reservation, long id);

    List<Reservation> getReservationsById(long theId);


    Reservation update(Reservation reservation, long id, LocalDate start, LocalDate end);

    public List<Reservation> findByName(String name);

    List<Reservation> findRezervedPropertiesById(long id);
}
