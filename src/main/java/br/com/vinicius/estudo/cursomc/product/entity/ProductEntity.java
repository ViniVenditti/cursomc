package br.com.vinicius.estudo.cursomc.product.entity;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.order.entity.OrderEntity;
import br.com.vinicius.estudo.cursomc.order.entity.OrderItemEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "PRODUCT_CATEGORY",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItemEntity> items = new HashSet<>();

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @JsonIgnore
    public List<OrderEntity> getOrders() {
        List<OrderEntity> list = new ArrayList<>();
        for (OrderItemEntity x : items) list.add(x.getOrderEntity());
        return list;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public List<CategoryEntity> getCategories() {
        return categories;
    }
    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
