package com.marc7n.PropertyForRent.repository;

import com.marc7n.PropertyForRent.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAll();
    @Query(value = "SELECT * FROM reservations  where id = ?1", nativeQuery = true)
     public Reservation findByIdReservation(long id);

    @Query(value = "SELECT * FROM reservations  where tenant_name = ?1", nativeQuery = true)
    List<Reservation> findByName(String name);

    @Query(value = "SELECT * FROM reservations  where property_id = ?1", nativeQuery = true)
    List<Reservation> findRezervedPropertiesById(long id);

}

