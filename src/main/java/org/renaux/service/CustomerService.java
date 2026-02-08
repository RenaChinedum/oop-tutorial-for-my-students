package org.renaux.service;

import lombok.RequiredArgsConstructor;
import org.renaux.model.PersonRequest;
import org.renaux.model.business.Cart;
import org.renaux.model.business.Product;
import org.renaux.model.business.Wishlist;
import org.renaux.model.enums.StockStatus;
import org.renaux.model.human.externals.Customer;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CustomerService {
    private final WalletService walletService;

    public Customer createCutomer(PersonRequest request){
        Customer customer = new Customer();
        customer.setId(request.getId());
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setAge(request.getAge());
        customer.setGender(request.getGender());
        customer.setWallet(walletService.createWallet(request.getId()));
        return customer;
    }

    public Cart addToCart(Customer customer, String id, int quantity){
        List<Product> cartProducts = new ArrayList<>();
        Product product = ProductService.inventory.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " not found in inventory."));
        cartProducts.add(product);
        validateQuantity(product, quantity);
        updateInventoryQuatity(product, quantity);
        Cart cart = new Cart(cartProducts);
        customer.setCart(cart);
        return cart;
    }

    private void updateInventoryQuatity(Product product, int quantity) {
        product.setQuantity(product.getQuantity() - quantity);
        if (product.getQuantity() == 0) {
            product.setStockStatus(StockStatus.OUT_OF_STOCK);
        }
    }

    private void validateQuantity(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Requested quantity exceeds available stock for product: " + product.getName());
        }
    }

     public void addToWishlist(Customer customer, Product product){
       List<Product> wishlistProducts = new ArrayList<>();
         Wishlist list = new Wishlist();
         list.setProducts(wishlistProducts);
         wishlistProducts.add(product);
         customer.setWishlist(list);
         System.out.println("Product " + product.getName() + " added to wishlist.");
     }
}
