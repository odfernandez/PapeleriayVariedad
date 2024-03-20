package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.controllers;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Category;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/")
    public String holaMundo(){
        return "HOLA MUNDO!!!!";
    }

    @GetMapping(value = "/api/v1/categories/findAllCategories")
    public List<Category> findAllCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping(value = "/api/v1/categories/findCategoryById/{id}")
    public Category findCategoryById(@PathVariable Long id) throws ModelNotFoundException {
        return categoryService.findCategoryById(id);
    }

    @GetMapping(value = "/api/v1/categories/findCategoryByNameWithJPQL/{description}")
    Optional<Category> findCategoryByNameWithJPQL(@PathVariable String description){
        return categoryService.findCategoryByNameWithJPQL(description);
    }

    @PostMapping(value = "/api/v1/categories/saveCategory")
    public Category saveCategory(@Valid @RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping(value = "/api/v1/categories/updateCategory/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping(value = "/api/v1/categories/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return "Successfully Deleted";
    }

}
