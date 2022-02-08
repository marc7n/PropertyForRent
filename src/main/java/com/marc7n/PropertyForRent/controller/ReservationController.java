package com.marc7n.PropertyForRent.controller;

import com.marc7n.PropertyForRent.entity.Property;
import com.marc7n.PropertyForRent.entity.Reservation;
import com.marc7n.PropertyForRent.repository.ReservationRepository;
import com.marc7n.PropertyForRent.service.PropertyService;
import com.marc7n.PropertyForRent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    public ReservationService reservationService;
    public PropertyService propertyService;

    @Autowired
    public ReservationController(ReservationService theReservationService, PropertyService thPropertyService) {
        reservationService = theReservationService;
        propertyService = thPropertyService;
    }
    @Autowired
    public ReservationRepository reservationRepository;

    @GetMapping("/all")
    public Iterable<Reservation> allReservations() {
        return reservationService.getReservations();
    }


    @PostMapping(value = "/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Property property = propertyService.findByIdProperty(reservation.getProperty().getId());
        System.out.println(property.getId());
        if (property == null) {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
        Reservation reservation1 = reservationService.create(reservation, property.getId());
        return new ResponseEntity<Reservation>(reservation1, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public Reservation updateReservation(@PathVariable  long id, @RequestBody Reservation reservation){
        Reservation reservation1 = reservationRepository.findById(id).get();
        if (reservation1 != null)
            return reservationService.update(reservation, reservation.getId(), reservation.getStartReservation(), reservation.getEndReservation());
        else

            throw new NullPointerException("no reservation found");
    }

    @RequestMapping(value = "/name/{name}")
    public List<Reservation> getAllReservationsByName(@PathVariable("name") String name) {
        List<Reservation> res = reservationService.findByName(name);
        return res;
    }

    @RequestMapping(value = "/id/{id}")
    public List<Reservation> getRezervationsByProperties(@PathVariable("id") long id) {
        List<Reservation> res = reservationService.findRezervedPropertiesById(id);
        return res;
    }
}
