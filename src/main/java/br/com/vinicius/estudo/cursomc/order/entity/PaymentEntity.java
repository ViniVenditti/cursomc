package br.com.vinicius.estudo.cursomc.order.entity;

import br.com.vinicius.estudo.cursomc.enums.StatePayment;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentEntity {

    @Id
    private Long id;
    private Integer statePayment;

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private OrderEntity order;

    public PaymentEntity() {
    }

    public PaymentEntity(Long id, StatePayment statePayment, OrderEntity order) {
        this.id = id;
        this.statePayment = statePayment.getCod();
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatePayment getStatePayment() {
        return StatePayment.toEnum(statePayment);
    }

    public void setStatePayment(StatePayment statePayment) {
        this.statePayment = statePayment.getCod();
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
