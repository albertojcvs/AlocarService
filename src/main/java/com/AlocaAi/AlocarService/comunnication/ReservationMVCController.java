
package com.AlocaAi.AlocarService.comunnication;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlocaAi.AlocarService.model.Resevation.Reservation;
import com.AlocaAi.AlocarService.model.Resevation.ReservationController;


class CreateReservationDTO {
    public Long userId;
    public String equipmentType;
    public Date startDate; 
    public Date endDate;
}

@RestController
@RequestMapping("/reservation")
public class ReservationMVCController {
        @Autowired private ReservationController controller;


    @PostMapping("")
    public Reservation createReservation(@RequestBody CreateReservationDTO createReservationDTO) {
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println(createReservationDTO.equipmentType);
        System.out.println(createReservationDTO.userId);
        System.out.println(createReservationDTO.endDate);
        System.out.println(createReservationDTO.startDate);
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println(createReservationDTO);
        return controller.createReservation(createReservationDTO.userId, createReservationDTO.equipmentType, createReservationDTO.startDate, createReservationDTO.endDate );
    }

}
