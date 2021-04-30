package br.com.vinicius.estudo.cursomc.order.entity;

import br.com.vinicius.estudo.cursomc.enums.StatePayment;

import javax.persistence.Entity;

@Entity
public class PaymentCardEntity extends PaymentEntity{

    private Integer numberInstallments;

    public PaymentCardEntity() {
    }

    public PaymentCardEntity(Long id, StatePayment statePayment, OrderEntity order, Integer numberInstallments){
        super(id, statePayment, order);
        this.numberInstallments = numberInstallments;
    }

    public Integer getNumberInstallments() {
        return numberInstallments;
    }

    public void setNumberInstallments(Integer numberInstallments) {
        this.numberInstallments = numberInstallments;
    }
}
