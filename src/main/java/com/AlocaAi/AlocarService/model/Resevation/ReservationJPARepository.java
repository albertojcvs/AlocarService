package com.AlocaAi.AlocarService.model.Resevation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AlocaAi.AlocarService.model.equipment.EquipamentDAO;
import com.AlocaAi.AlocarService.model.equipment.Equipment;
import com.AlocaAi.AlocarService.model.user.User;
import com.AlocaAi.AlocarService.model.user.UserDAO;

@Component
public class ReservationJPARepository implements IReservationRepository {

    @Autowired private ReservationDAO reservationDAO;
    @Autowired private UserDAO userDAO;
    @Autowired private EquipamentDAO equipamentDAO;

    public Reservation createReservation(Reservation reservation) {
        User user = userDAO.findById(reservation.getUser().getId()).orElse(null);
        if(user == null) {
            userDAO.save(reservation.getUser());
        }

        Equipment equipment = equipamentDAO.findById(reservation.getEquipment().getId()).orElse(null);
        if(equipment == null) {
            equipamentDAO.save(reservation.getEquipment());
        }
        return reservationDAO.save(reservation);
    }

    public boolean isFreeInDate(Long equipmentId, Date startDate, Date endDate) {

        List result = reservationDAO.findByEquipmentIdAndStartDateBetween(equipmentId, startDate,endDate);

        System.err.println(result.size());
        System.err.println("result.size()");
        System.err.println("result.size()");
        System.err.println("result.size()");
        System.err.println("result.size()");
        return   result.size() == 0;
    }
}
