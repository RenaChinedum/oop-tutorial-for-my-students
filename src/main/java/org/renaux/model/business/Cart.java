package org.renaux.model.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    private List<Product> products;
    private BigDecimal total;

    public Cart(List<Product> products) {
        this.products = products;
        products.forEach(p ->{
            this.total = BigDecimal.ZERO;
            total = total.add(BigDecimal.valueOf(p.getPrice()).multiply(BigDecimal.valueOf(p.getQuantity())));
        });
    }
}
