package com.AlocaAi.AlocarService.services.cadastro;

import java.util.List;

import com.AlocaAi.AlocarService.model.equipment.Equipment;

public interface ICadastroService {
    public List<Equipment> listEquipment();
    public Equipment updateEquipment(Long equipmentId, String status);
}
