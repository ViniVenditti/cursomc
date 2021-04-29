package br.com.vinicius.estudo.cursomc.client.controller;

import br.com.vinicius.estudo.cursomc.client.entity.ClientEntity;
import br.com.vinicius.estudo.cursomc.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<ClientEntity> findClient(@PathVariable Long id) {
        ClientEntity client = clientService.getClient(id);
        return ResponseEntity.ok().body(client);
    }

}
