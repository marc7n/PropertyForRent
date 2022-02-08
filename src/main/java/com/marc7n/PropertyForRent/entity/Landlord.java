package com.marc7n.PropertyForRent.entity;

import com.fasterxml.jackson.annotation.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "landlordId")
public class Landlord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long landlordId;

    private String name;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "landlord", fetch = FetchType.LAZY)
    private List<Reservation> landlordReservations;

    public long getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(long id) {
        this.landlordId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getLandlordReservations() {
        return landlordReservations;
    }

    public void setLandlordReservations(List<Reservation> landlordReservations) {
        this.landlordReservations = landlordReservations;
    }
}