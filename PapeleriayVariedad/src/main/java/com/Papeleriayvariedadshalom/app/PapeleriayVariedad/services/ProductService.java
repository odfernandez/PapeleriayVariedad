package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductById(Long id) throws ModelNotFoundException;
    Product saveProduct(Product product) throws ModelNotFoundException;
    Product updateProduct(Long id, Product product) throws ModelNotFoundException;
    void deleteProduct(Long id);
}
