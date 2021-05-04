package br.com.vinicius.estudo.cursomc.category.controller;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.category.mapper.CategoryMapper;
import br.com.vinicius.estudo.cursomc.category.model.CategoryModel;
import br.com.vinicius.estudo.cursomc.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @Autowired
    private CategoryMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> getCategory(@PathVariable Long id) {
        CategoryEntity categoryEntity = service.getCategory(id);
        return ResponseEntity.ok().body(categoryEntity);
    }

    @PostMapping
    public ResponseEntity<CategoryEntity> insertCategory(@RequestBody CategoryModel model) {
        CategoryEntity entity = service.saveCategory(mapper.from(model));
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id, @RequestBody CategoryModel model){
        CategoryEntity entity = service.updateCategory(id, model);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();

    }
}
