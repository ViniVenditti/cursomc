package br.com.vinicius.estudo.cursomc.order.service;

import br.com.vinicius.estudo.cursomc.order.entity.OrderEntity;
import br.com.vinicius.estudo.cursomc.order.repository.OrderRepository;
import br.com.vinicius.estudo.cursomc.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    public OrderEntity getOrder(Long id) {
        Optional<OrderEntity> byId = OrderRepository.findById(id);
        if (byId.isPresent())
            return byId.get();
        throw new OrderNotFoundException();
    }
}