package com.AlocaAi.AlocarService.model.equipment;

import java.util.List;

import com.AlocaAi.AlocarService.model.Resevation.Reservation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Equipment {
    @Id
    public Long id;

    public String status;

    public String type;
    
    public String name;

    @ManyToMany(mappedBy = "equipment", cascade = CascadeType.ALL )
    List<Reservation> reservations;

    
    public Equipment() {}

    public Equipment(Long id, String status, String type, String name) {
        this.id = id;
        this.status = status;
        this.type = type;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
