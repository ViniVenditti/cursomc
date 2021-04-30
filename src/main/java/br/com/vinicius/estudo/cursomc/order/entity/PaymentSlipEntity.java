package br.com.vinicius.estudo.cursomc.order.entity;

import br.com.vinicius.estudo.cursomc.enums.StatePayment;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentSlipEntity extends PaymentEntity{

    private Date dateExpiration;
    private Date datePayment;

    public PaymentSlipEntity() {}

    public PaymentSlipEntity(Long id, StatePayment statePayment, OrderEntity order, Date dateExpiration, Date datePayment) {
        super(id, statePayment, order);
        this.dateExpiration = dateExpiration;
        this.datePayment = datePayment;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }
}
