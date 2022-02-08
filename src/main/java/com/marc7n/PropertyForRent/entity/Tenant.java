package com.marc7n.PropertyForRent.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Table
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tenantId")
public class Tenant implements Serializable {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private long tenantId;

    private String tenantName;
    @JsonIgnore
    @OneToMany(targetEntity = Reservation.class, mappedBy = "tenant", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Reservation> tenantReservations;

    public Tenant(long tenantId, String tenantName, List<Reservation> tenantReservations) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.tenantReservations = tenantReservations;
    }

    public Tenant() {

    }

//    public List<Reservation> getResList() {
//        return resList;
//    }
//
//    public void setResList(List<Reservation> resList) {
//        this.resList = resList;
//    }

    public long getTenantId() {
        return tenantId;
    }

    public void setTenantId(long id) {
        this.tenantId = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public List<Reservation> getTenantReservations() {
        return tenantReservations;
    }

    public void setTenantReservations(List<Reservation> tenantReservations) {
        this.tenantReservations = tenantReservations;
    }
}