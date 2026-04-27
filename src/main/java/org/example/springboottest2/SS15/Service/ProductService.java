package org.example.springboottest2.SS15.Service;

import org.example.springboottest2.SS15.Repository.ProductRepository;
import org.example.springboottest2.SS15.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product create(Product p) {
        return repo.save(p);
    }

    public Product update(Long id, Product p) {
        Product old = repo.findById(id).orElseThrow();

        old.setName(p.getName());
        old.setDescription(p.getDescription());
        old.setPrice(p.getPrice());
        old.setSize(p.getSize());
        old.setToppings(p.getToppings());

        return repo.save(old);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}