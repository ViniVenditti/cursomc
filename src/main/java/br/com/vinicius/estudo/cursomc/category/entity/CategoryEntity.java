package br.com.vinicius.estudo.cursomc.category.entity;

import br.com.vinicius.estudo.cursomc.product.entity.ProductEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonManagedReference
    @ManyToMany(mappedBy = "categories")
    private List<ProductEntity> products = new ArrayList<>();

    public CategoryEntity() {
    }

    public CategoryEntity(String name) {
        this.name = name;
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
    public List<ProductEntity> getProducts() {
        return products;
    }
    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
