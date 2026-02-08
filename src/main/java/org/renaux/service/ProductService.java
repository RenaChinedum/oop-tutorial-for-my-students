package org.renaux.service;

import lombok.RequiredArgsConstructor;
import org.renaux.file.FileHandler;
import org.renaux.model.ProductRequest;
import org.renaux.model.business.Product;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProductService {

    public static final List<Product> inventory = new ArrayList<>();

    public void createProducts() {
        List<ProductRequest> requests = FileHandler.readCsv();
        requests.forEach(request -> {
            Product product = createPrduct(request);
            inventory.add(product);
        });
        System.out.println("Products created successfully. Total products in inventory: " + inventory.size());
    }

    public void deleteProduct(String id) {
        inventory.forEach(p -> {
            if(p.getId().equalsIgnoreCase(id)){
                inventory.remove(p);
                System.out.println("Product with ID " + id + " has been deleted.");
            }
        });
        FileHandler.saveProductsToFile(inventory);
    }

    private Product createPrduct(ProductRequest request) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .stockStatus(request.getStockStatus())
                .build();
    }
}
