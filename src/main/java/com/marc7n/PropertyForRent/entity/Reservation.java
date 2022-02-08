package com.marc7n.PropertyForRent.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate startReservation;

    private LocalDate endReservation;

    private double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_name", referencedColumnName = "tenantName")
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenantId")
    private Tenant tenant;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    public Reservation(long id, LocalDate startReservation, LocalDate endReservation, double totalPrice, Property property, Tenant tenant, Landlord landlord) {
        this.id = id;
        this.startReservation = startReservation;
        this.endReservation = endReservation;
        this.totalPrice = totalPrice;
        this.property = property;
        this.tenant = tenant;
        this.landlord = landlord;
    }

    public Reservation() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(LocalDate startReservation) {
        this.startReservation = startReservation;
    }

    public LocalDate getEndReservation() {
        return endReservation;
    }

    public void setEndReservation(LocalDate endReservation) {
        this.endReservation = endReservation;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }
}

