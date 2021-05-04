package br.com.vinicius.estudo.cursomc.category.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoryModel {

    @NotBlank
    @JsonProperty(value = "nome")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
