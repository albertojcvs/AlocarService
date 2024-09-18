package com.AlocaAi.AlocarService.model.Resevation;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AlocaAi.AlocarService.model.equipment.Equipment;
import com.AlocaAi.AlocarService.model.user.User;
import com.AlocaAi.AlocarService.services.cadastro.ICadastroService;
import com.AlocaAi.AlocarService.services.calendar.ICalendarService;

@Component
public class ReservationController {
    @Autowired private ReservationCollection reservationCollection;

    @Autowired private ICalendarService calendarService ;

    @Autowired private ICadastroService cadastroService ;

    private User getUser(Long userId) {
        return new User(userId);
    }

    private Equipment getFreeEquipmentByType(String equipmentType, Date startDate, Date endDate) {
        List<Equipment> equipments = cadastroService.listEquipment();

        for(Equipment equipment : equipments) {
            System.out.println(equipment.type);
            System.out.println(equipment.status);
            System.out.println(equipment.type == equipmentType);
            if(equipment.type.equals(equipmentType) && !equipment.status.equals("allocated")) {
                boolean isFree = this.reservationCollection.isFreeInDate(equipment.id, startDate, endDate);
                System.out.println("isFree");
                System.out.println(isFree);
                return equipment;

            //    if(isFree)
            //    continue;
            }
        }

        return null;
    }

    public Reservation createReservation(Long userId, String equipmentType, Date startDate, Date endDate) {
        Long id = (long) 1;
        User user = this.getUser(userId);
        System.out.println("---------------");
        System.out.println("pegou o user");
        System.out.println("---------------");
        if (user.equals(null)) {
            throw new Error();
        }

        Equipment equipment = this.getFreeEquipmentByType(equipmentType, startDate, endDate);
        System.out.println("---------------");
        System.out.println("pegou o equipment");
        System.out.println("---------------");
        if (equipment == null) {
            System.out.println("---------------");
            System.out.println("bbbbbbbbbbbb");
            throw new Error("No equipment is available");
        }
        System.out.println("---------------");
        System.out.println("aaaaaaaaaaaaaaaa");
        System.out.println("---------------");

        Reservation reservation = new Reservation(id, equipment, user, startDate, endDate);

        this.reservationCollection.createReservation(reservation);

        this.cadastroService.updateEquipment(equipment.id, "allocated");


        String description = equipment.name + "is reserved!";
        String title = equipment.name + " - " + equipment.id;

        // calendarService.saveEvent(title, description, startDate, endDate);

        return reservation;
    }
}
