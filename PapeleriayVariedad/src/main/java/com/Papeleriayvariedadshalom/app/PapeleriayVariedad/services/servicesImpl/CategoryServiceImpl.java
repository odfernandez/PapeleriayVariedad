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
        if (category.isEmpty()){
            throw new ModelNotFoundException("Category is not available.");
        }
        return category.get();
    }

    @Override
    public Optional<Category> findCategoryByNameWithJPQL(String description) throws ModelNotFoundException {
        Optional<Category> category = categoryRepository.findCategoryByNameWithJPQL(description);
        if (category.isEmpty()){
            throw new ModelNotFoundException("Verify your Category Name or Category is not available.");
        }
        return category;
    }

    @Override
    public Optional<Category> findByDescription(String description) throws ModelNotFoundException {
        Optional<Category> category = categoryRepository.findByDescription(description);
        if (category.isEmpty()){
            throw new ModelNotFoundException("Verify your Category Name or Category is not available.");
        }
        return category;
    }

    @Override
    public Optional<Category> findByDescriptionIgnoreCase(String description) throws ModelNotFoundException {
        Optional<Category> category = categoryRepository.findByDescriptionIgnoreCase(description);
        if (category.isEmpty()){
            throw new ModelNotFoundException("Category is not available.");
        }
        return category;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) throws ModelNotFoundException {
       Category categoryDb = categoryRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Category with ID: " + id + " is not available."));
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
