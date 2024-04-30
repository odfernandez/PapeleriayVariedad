package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.controllers;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Product;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(
        origins = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS
        }
)
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "findAllProducts")
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping(value = "findProductById/{id}")
    public Product findProductById(@PathVariable Long id) throws ModelNotFoundException {
        return productService.findProductById(id);
    }

    @PostMapping(value = "saveProduct")
    public Product saveProduct(@Valid @RequestBody Product product) throws ModelNotFoundException {
        return productService.saveProduct(product);
    }

    @PutMapping(value = "updateProduct/{id}")
    public Product updateProduct(@Valid @PathVariable Long id, @RequestBody Product product) throws ModelNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping(value = "deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Successfully Deleted";
    }
}
