package br.com.vinicius.estudo.cursomc.order.entity;

import br.com.vinicius.estudo.cursomc.product.entity.ProductEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderItemEntity {

    @JsonIgnore
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Double discount;
    private Integer amount;
    private Double price;

    public OrderItemEntity() {
    }

    public OrderItemEntity(OrderEntity orderEntity, ProductEntity productEntity, Double discount, Integer amount, Double price) {
        id.setOrder(orderEntity);
        id.setProduct(productEntity);
        this.discount = discount;
        this.amount = amount;
        this.price = price;
    }

    @JsonIgnore
    public OrderEntity getOrderEntity() {
        return id.getOrder();
    }

    public ProductEntity getProductEntity() {
        return id.getProduct();
    }

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
