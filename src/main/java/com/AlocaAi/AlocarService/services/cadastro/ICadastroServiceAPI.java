package com.AlocaAi.AlocarService.services.cadastro;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.AlocaAi.AlocarService.model.equipment.Equipment;


class InputUpdateEquipment {
    public Long id;
    public String status;
    public InputUpdateEquipment(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}

class UserWithouId {
    public Long id;
    public String email;
    public UserWithouId(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}

@FeignClient(contextId = "CadastroService", name = "CadastroService", url = "https://gateway.scarletserver.tech/entidades")
@Validated
public interface ICadastroServiceAPI {

	@GetMapping(value = "/equipamento/disponiveis", produces = "*/*")
	ResponseEntity<List<Equipment>> listEquipment ();

    @GetMapping(value = "/usuario/{id}", produces = "*/*")
	ResponseEntity<UserWithouId> getUser (@PathVariable("id") Long id);
}