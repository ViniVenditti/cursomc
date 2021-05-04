package br.com.vinicius.estudo.cursomc.category.service;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.category.model.CategoryModel;
import br.com.vinicius.estudo.cursomc.exceptions.CategoryNotFoundException;
import br.com.vinicius.estudo.cursomc.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public CategoryEntity getCategory(Long id) {
        Optional<CategoryEntity> byId = repo.findById(id);
        if(byId.isPresent())
            return byId.get();
        throw new CategoryNotFoundException();
    }

    public CategoryEntity saveCategory(CategoryEntity entity) {
        CategoryEntity save = repo.save(entity);
        return save;
    }

    public CategoryEntity updateCategory(Long id, CategoryModel model){
        CategoryEntity entity = getCategory(id);
        entity.setName(model.getName());
        CategoryEntity categoryUpdated = repo.save(entity);
        return categoryUpdated;
    }

}
