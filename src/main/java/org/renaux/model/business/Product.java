package org.renaux.model.business;

import lombok.*;
import org.renaux.model.enums.StockStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private StockStatus stockStatus;
}
