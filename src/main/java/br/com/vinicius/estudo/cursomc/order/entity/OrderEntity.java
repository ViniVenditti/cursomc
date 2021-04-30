package br.com.vinicius.estudo.cursomc.order.entity;

import br.com.vinicius.estudo.cursomc.address.entity.AddressEntity;
import br.com.vinicius.estudo.cursomc.client.entity.ClientEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private AddressEntity deliveryAddress;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItemEntity> items = new HashSet<>();

    public OrderEntity() {
    }

    public OrderEntity(Long id, Date instant, ClientEntity client, AddressEntity deliveryAddress) {
        this.id = id;
        this.instant = instant;
        this.client = client;
        this.deliveryAddress = deliveryAddress;
    }

    public Set<OrderItemEntity> getItems() {
        return items;
    }
    public void setItems(Set<OrderItemEntity> items) {
        this.items = items;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getInstant() {
        return instant;
    }
    public void setInstant(Date instant) {
        this.instant = instant;
    }
    public PaymentEntity getPayment() {
        return payment;
    }
    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }
    public ClientEntity getClient() {
        return client;
    }
    public void setClient(ClientEntity client) {
        this.client = client;
    }
    public AddressEntity getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(AddressEntity deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
