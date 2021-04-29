package br.com.vinicius.estudo.cursomc.category.service;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.exceptions.CategoryNotFoundException;
import br.com.vinicius.estudo.cursomc.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
