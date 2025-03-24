package api.webfashionstore.service;

import api.webfashionstore.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    void updateProduct(Product product);

    void deleteProduct(int id);


}
