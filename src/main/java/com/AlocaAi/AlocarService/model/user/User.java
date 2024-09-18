package com.AlocaAi.AlocarService.model.user;

import java.util.List;

import com.AlocaAi.AlocarService.model.Resevation.Reservation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
    @Id
    Long id;


    @ManyToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Reservation> reservations;


    public User() {
    }

    public User(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public List<Reservation> getReservations() {
        return reservations;
    }


    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


}
