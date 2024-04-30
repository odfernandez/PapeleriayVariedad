package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryById(Long id) throws ModelNotFoundException;
    Optional<Category> findCategoryByNameWithJPQL(String description) throws ModelNotFoundException;
    Optional<Category> findByDescription(String description) throws ModelNotFoundException;
    Optional<Category> findByDescriptionIgnoreCase(String description) throws ModelNotFoundException;
    Category saveCategory(Category category);
    Category updateCategory(Long id, Category category) throws ModelNotFoundException;
    void deleteCategory(Long id);

}
