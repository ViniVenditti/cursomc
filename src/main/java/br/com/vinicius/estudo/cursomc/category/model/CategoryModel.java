package br.com.vinicius.estudo.cursomc.category.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

public class CategoryModel {

    @Null
    private Long id;

    @NotBlank
    @JsonProperty(value = "nome")
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
