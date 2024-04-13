package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllEmployees(){
        return this.productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getAllEmployees(@PathVariable("id") Integer id){
        return this.productService.getProductById(id);
    }

    @PostMapping("/product")
    public void createProduct(@RequestBody Product newProduct) {
        productService.addEmployee(newProduct);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee updatedProduct) {
        return productService.updateProduct(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}
