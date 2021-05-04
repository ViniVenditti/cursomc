package br.com.vinicius.estudo.cursomc.category.service;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.category.mapper.CategoryMapper;
import br.com.vinicius.estudo.cursomc.category.model.CategoryModel;
import br.com.vinicius.estudo.cursomc.category.repository.CategoryRepository;
import br.com.vinicius.estudo.cursomc.exceptions.CategoryNotFoundException;
import br.com.vinicius.estudo.cursomc.exceptions.PermissionDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    @Autowired
    private CategoryMapper mapper;

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

    public void deleteCategory(Long id) {
        CategoryEntity category = getCategory(id);
        try{
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new PermissionDeniedException();
        }
    }

    public List<CategoryModel> getAllCategory() {
        List<CategoryEntity> all = repo.findAll();
        return all
                .stream()
                .map(entity -> mapper.to(entity))
                .collect(Collectors.toList());
    }
}
