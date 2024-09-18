package com.AlocaAi.AlocarService.model.Resevation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationJPARepository implements IReservationRepository {

    @Autowired private ReservationDAO reservationDAO;

    public Reservation createReservation(Reservation reservation) {
        return reservationDAO.save(reservation);
    }

    public boolean isFreeInDate(Long equipmentId, Date startDate, Date endDate) {
        System.out.println("------------------");
        System.out.println(equipmentId);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println("------------------");

        Reservation reservation  = reservationDAO.findByEquipmentIdAndStartDateBetween(equipmentId, startDate,endDate).orElse(null);
        System.out.println("vai retornar o boolean do repositorio");
        return reservation == null;
    }
}
