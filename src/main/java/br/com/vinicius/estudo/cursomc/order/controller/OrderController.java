package br.com.vinicius.estudo.cursomc.order.controller;

import br.com.vinicius.estudo.cursomc.order.entity.OrderEntity;
import br.com.vinicius.estudo.cursomc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pedido")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{id}")
    private ResponseEntity<OrderEntity> findOrder(@PathVariable Long id) {
        OrderEntity order = orderService.getOrder(id);
        return ResponseEntity.ok().body(order);
    }
}
