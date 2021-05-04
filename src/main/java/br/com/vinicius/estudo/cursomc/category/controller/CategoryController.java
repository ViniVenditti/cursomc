package br.com.vinicius.estudo.cursomc.category.controller;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.category.mapper.CategoryMapper;
import br.com.vinicius.estudo.cursomc.category.model.CategoryModel;
import br.com.vinicius.estudo.cursomc.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<CategoryModel>> getAllCategory() {
        List<CategoryModel> allCategory = service.getAllCategory();
        return ResponseEntity.ok().body(allCategory);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<CategoryModel>> getAllCategoryPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesByPage", defaultValue = "24") Integer linesByPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {
        Page<CategoryModel> categoryByPage = service.getCategoryByPage(page, linesByPage, orderBy, direction);
        return ResponseEntity.ok().body(categoryByPage);
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
