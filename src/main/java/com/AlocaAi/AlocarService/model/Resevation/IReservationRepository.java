package com.AlocaAi.AlocarService.model.Resevation;

import java.util.Date;

public interface IReservationRepository {
   public Reservation createReservation(Reservation reservation);
   public boolean isFreeInDate(Long equipmentId, Date startDate, Date emdDate);
}
