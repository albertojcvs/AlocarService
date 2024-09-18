package com.AlocaAi.AlocarService.model.Resevation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ReservationCollection {

    @Autowired private IReservationRepository repository;

    @Transactional
    public Reservation createReservation(Reservation reservation) {
        return repository.createReservation(reservation);
    }


    public boolean isFreeInDate(Long equipmentId, Date startDate, Date endDate) {
        return repository.isFreeInDate(equipmentId, startDate, endDate);
    }


    
}
