package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.servicesImpl;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Category;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories.CategoryRepository;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) throws ModelNotFoundException {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()){
            throw new ModelNotFoundException("Category is not available");
        }
        return category.get();
    }

    @Override
    public Optional<Category> findCategoryByNameWithJPQL(String description) {
        return categoryRepository.findCategoryByNameWithJPQL(description);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category categoryDb = categoryRepository.findById(id).get();
       if (Objects.nonNull(category.getDescription())&& !"".equalsIgnoreCase(category.getDescription())){
            categoryDb.setDescription(category.getDescription());
        }
       categoryDb.setState(category.isState());

        return categoryRepository.save(categoryDb);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
