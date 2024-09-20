package com.AlocaAi.AlocarService.services.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AlocaAi.AlocarService.model.equipment.Equipment;
import com.AlocaAi.AlocarService.model.user.User;

@Component
public class CadastroService implements ICadastroService{
    @Autowired ICadastroServiceAPI serviceAPI;

    public List<Equipment> listEquipment() {
        
        List<Equipment> array = serviceAPI.listEquipment().getBody();
        return array;
    }

    public User getUser(Long id) {
        UserWithouId user  = serviceAPI.getUser(id).getBody();
        if(user == null) {return null;}
        return new User(id, user.email);
    }

    public Equipment updateEquipment(Long id, String status) {
         return  serviceAPI.updateEquiment(new InputUpdateEquipment(id, status));
    }

}
