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

    public String tipo;
    
    public String serial;

    @ManyToMany(mappedBy = "equipment")
    List<Reservation> reservations;

    
    public Equipment() {}

    public Equipment(Long equipamentoId, String status, String tipo, String serial) {
        this.id = equipamentoId;
        this.status = status;
        this.tipo = tipo;
        this.serial = serial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
