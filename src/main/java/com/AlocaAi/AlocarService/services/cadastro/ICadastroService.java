package com.AlocaAi.AlocarService.services.cadastro;

import java.util.List;

import com.AlocaAi.AlocarService.model.equipment.Equipment;
import com.AlocaAi.AlocarService.model.user.User;

public interface ICadastroService {
    public List<Equipment> listEquipment();

    public User getUser(Long id);

    public Equipment updateEquipment(Long id, String status);
}
