package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public  Product getProductById(Integer id){
        return productRepository.findById(id).get();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product newProduct){
        return productRepository.findById(id)
            .map(product -> {
                product.setProductId(newProduct.getProductId());
                product.setName(newProduct.getName());
                product.setDescription(newProduct.getDescription());
                product.setCategory(newProduct.getCategory());
                product.setRating(newProduct.getRating());
                product.setPrice(newProduct.getPrice());
                product.setQuantity(newProduct.getQuantity());
        return productRepository.save(newProduct);
    })
            .orElseGet(() -> {
        newProduct.setProductId(id);
        return productRepository.save(newProduct);
    });
    }
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
