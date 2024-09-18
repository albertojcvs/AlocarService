package com.AlocaAi.AlocarService.model.user;

import java.util.List;

import com.AlocaAi.AlocarService.model.Resevation.Reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
    @Id
    public Long id;


    public String email;


    @ManyToMany(mappedBy = "user")
    List<Reservation> reservations;


    public User() {
    }

    public User(Long id, String email) {
        this.id = id;
        this.email = email;
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
