package br.com.vinicius.estudo.cursomc.category.mapper;

import br.com.vinicius.estudo.cursomc.category.entity.CategoryEntity;
import br.com.vinicius.estudo.cursomc.category.model.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    private CategoryMapper() {}

    public CategoryEntity from (CategoryModel model){
        CategoryEntity entity = new CategoryEntity();
        entity.setName(model.getName());
        return entity;
    }
}
