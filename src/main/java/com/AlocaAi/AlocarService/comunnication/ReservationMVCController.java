
package com.AlocaAi.AlocarService.comunnication;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createReservation(@RequestBody CreateReservationDTO createReservationDTO) {
        try {
            Reservation reservation = controller.createReservation(createReservationDTO.userId, createReservationDTO.equipmentType, createReservationDTO.startDate, createReservationDTO.endDate);
            return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
