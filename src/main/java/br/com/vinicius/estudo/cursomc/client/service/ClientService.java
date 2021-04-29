package br.com.vinicius.estudo.cursomc.client.service;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.client.entity.ClientEntity;
import br.com.vinicius.estudo.cursomc.client.repository.ClientRepository;
import br.com.vinicius.estudo.cursomc.exceptions.CategoryNotFoundException;
import br.com.vinicius.estudo.cursomc.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity getClient(Long id){
        Optional<ClientEntity> byId = clientRepository.findById(id);
        if(byId.isPresent())
            return byId.get();
        throw new ClientNotFoundException();
    }

}
