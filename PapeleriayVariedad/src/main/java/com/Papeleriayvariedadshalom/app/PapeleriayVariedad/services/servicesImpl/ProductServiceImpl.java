package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.servicesImpl;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Category;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Product;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories.CategoryRepository;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories.ProductRepository;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.CategoryService;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryService categoryService;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) throws ModelNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new ModelNotFoundException("Product is not available");
        }
        return product.get();
    }

    @Override
    public Product saveProduct(Product product) throws ModelNotFoundException {
        Category category = categoryService.findCategoryById(product.getCategory().getIdCategory());
        Product productDb = Product.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .category(category)
                .state(product.isState())
                .build();
        return productRepository.save(productDb);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ModelNotFoundException {
        Product productDb = findProductById(id);
        if (Objects.nonNull(product.getProductName())&& !"".equalsIgnoreCase(product.getProductName())){
            productDb.setProductName(product.getProductName());
        }
        productDb.setPrice(product.getPrice());
        productDb.setQuantity(product.getQuantity());
        productDb.setState(product.isState());
        productDb.setCategory(product.getCategory());

        return productRepository.save(productDb);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
