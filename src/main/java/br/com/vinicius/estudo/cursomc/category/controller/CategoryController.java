package br.com.vinicius.estudo.cursomc.category.controller;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> getCategorias(@PathVariable Long id) {
        CategoryEntity categoryEntity = service.getCategory(id);
        return ResponseEntity.ok().body(categoryEntity);
    }
}
