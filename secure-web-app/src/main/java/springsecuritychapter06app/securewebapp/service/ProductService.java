package springsecuritychapter06app.securewebapp.service;

import org.springframework.stereotype.Service;
import springsecuritychapter06app.securewebapp.model.Product;
import springsecuritychapter06app.securewebapp.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
