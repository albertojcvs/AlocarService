package com.AlocaAi.AlocarService.model.Resevation;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AlocaAi.AlocarService.model.equipment.Equipment;
import com.AlocaAi.AlocarService.model.user.User;
import com.AlocaAi.AlocarService.services.cadastro.ICadastroService;

@Component
public class ReservationController {
    @Autowired private ReservationCollection reservationCollection;

    @Autowired private ICadastroService cadastroService ;

    private User getUser(Long userId) {
        return this.cadastroService.getUser(userId);
    }

    private Equipment getFreeEquipmentByType(String equipmentType, Date startDate, Date endDate) {
        List<Equipment> equipments = cadastroService.listEquipment();
        for(Equipment equipment : equipments) {
            if(equipment.tipo.equals(equipmentType) && equipment.status.equals("DISPONIVEL")) {
                boolean isFree = this.reservationCollection.isFreeInDate(equipment.id, startDate, endDate);            
                   if(isFree) {return equipment;}
               continue;
            }
        }

        return null;
    }

    public Reservation createReservation(Long userId, String equipmentType, Date startDate, Date endDate) {
        User user = this.getUser(userId);
        if (user == null) {
            throw new Error("Usuario nao existe!");
        }

        Equipment equipment = this.getFreeEquipmentByType(equipmentType, startDate, endDate);
        if (equipment == null) {
            throw new Error("Sem Equipamento Disponivel!");
        }

        Reservation reservation = new Reservation(equipment, user, startDate, endDate);

        this.reservationCollection.createReservation(reservation);

        return reservation;
    }
}
