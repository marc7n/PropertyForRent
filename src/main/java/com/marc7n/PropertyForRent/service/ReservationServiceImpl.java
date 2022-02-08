package com.marc7n.PropertyForRent.service;

import com.marc7n.PropertyForRent.entity.Property;
import com.marc7n.PropertyForRent.entity.Reservation;
import com.marc7n.PropertyForRent.repository.PropertyRepository;
import com.marc7n.PropertyForRent.repository.ReservationRepository;
import com.marc7n.PropertyForRent.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ReservationServiceImpl implements ReservationService, PropertyService {

    public ReservationRepository reservationRepository;
    public PropertyRepository propertyRepository;
    public TenantRepository tenantRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository theReservationRepository, PropertyRepository thePropertyRepository, TenantRepository theTenantRepository) {
        propertyRepository = thePropertyRepository;
        reservationRepository = theReservationRepository;
        tenantRepository = theTenantRepository;
    }

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }


    public Property findByIdProperty(long id) {
        Optional<Property> property = Optional.of(propertyRepository.findById(id).get());
        return property.orElse(null);
    }

    @Override
    public Reservation create(Reservation reservation, long id) {
        if (checkBookIsPossible(id, Date.valueOf(reservation.getStartReservation()), Date.valueOf(reservation.getEndReservation()))) {
            {
                calcTotalPrice(reservation, id);
                return reservationRepository.save(reservation);
            }
        } else throw new RuntimeException("Please change period of booking! ");

    }

    private void calcTotalPrice(Reservation reservation, long id) {
        Optional<Property> property = propertyRepository.findById(id);
        double propertyPrice = property.get().getPrice();
        long dayOfBooking = DAYS.between(reservation.getStartReservation(), (reservation.getEndReservation()));
        reservation.setTotalPrice(propertyPrice * dayOfBooking);
    }


    @Override
    public List<Reservation> getReservationsById(long theId) {
        List<Reservation> result = reservationRepository.findAll();
        List<Reservation> list = result.stream()
                .filter(reservation -> reservation.getProperty().getId() == theId)
                .collect(Collectors.toList());
        return list;
    }


    @Override
    public Reservation update(Reservation reservation, long id, LocalDate start, LocalDate end) {
        Reservation res = reservationRepository.findByIdReservation(id);
            reservation.setStartReservation(start);
            reservation.setEndReservation(end);
            return reservationRepository.save(reservation);
        }

    @Override
    public List<Reservation> findByName(String name) {
            return reservationRepository.findByName(name);
    }

    @Override
    public List<Reservation> findRezervedPropertiesById(long id) {
        return reservationRepository.findRezervedPropertiesById(id);
    }


    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);

    }

    public Boolean checkBookIsPossible(long id, Date start_rent, Date end_rent) {
        List<Reservation> rents = getReservationsById(id);
        if (!rents.isEmpty()) {
            for (Reservation el : rents) {
                if (isOverlapping(start_rent, end_rent, Date.valueOf(el.getStartReservation()), Date.valueOf(el.getEndReservation())))
                    return false;
            }
        }
        return true;
    }
}
