package org.renaux.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.renaux.model.enums.StockStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private StockStatus stockStatus;
}
