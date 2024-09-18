package com.AlocaAi.AlocarService.model.Resevation;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReservationDAO extends CrudRepository<Reservation, Long> {
   List<Reservation> findByEquipmentIdAndStartDateBetween(Long equipmentId, Date startDate, Date enDate);
}
