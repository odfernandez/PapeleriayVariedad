package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Category;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Product;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void saveProduct(){
        /*Category category = Category.builder()
                .description("Belleza")
                .state(true)
                .build();*/
        Category category = categoryRepository.findById(2l).get();

        Product product = Product.builder()
                .productName("Block de Papel Rayado")
                .price(3500)
                .quantity(30)
                .category(category)
                .state(true)
                .build();
        productRepository.save(product);
    }

    @Test
    public void findProductById(){
        Product product = productRepository.findById(16L).get();
        System.out.println("El producto es:" + product);
    }

}