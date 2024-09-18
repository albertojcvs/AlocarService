package com.AlocaAi.AlocarService.services.cadastro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.AlocaAi.AlocarService.model.equipment.Equipment;

@Component
public class CadastroService implements ICadastroService{
    Equipment e = new Equipment((long)1, "free", "datashow", "Datashow 123");
    
    public List<Equipment> listEquipment() {
        
        List<Equipment> array = new ArrayList<Equipment>(); 
        array.add(e);
        System.out.println("vai retornar o array de equipment");
        return array;
    }


    public Equipment updateEquipment(Long equipmentId, String status) {
        return e;
    }
}
