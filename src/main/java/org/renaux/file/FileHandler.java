package org.renaux.file;

import org.renaux.model.ProductRequest;
import org.renaux.model.business.Product;
import org.renaux.model.enums.StockStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_PATH = "/Users/mac/Downloads/products.csv";

    public static List<ProductRequest> readCsv() {

        List<ProductRequest> requests = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine();
            System.out.println("skipped header");
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                if (data.length >= 4) {
                    ProductRequest product = ProductRequest.builder()
                            .id(data[0])
                            .name(data[1])
                            .description(data[2])
                            .price(Double.parseDouble(data[3]))
                            .quantity(Integer.parseInt(data[4]))
                            .stockStatus(data[4] != null ? StockStatus.IN_STOCK : StockStatus.OUT_OF_STOCK)
                            .build();
                    requests.add(product);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return requests;
    }

    public static void saveProductsToFile(List<Product> products) {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Product p : products) {

                String line = p.getId() + "," + p.getName() +"," + p.getDescription()+ "," + p.getPrice() + "," + p.getQuantity() + "," + p.getStockStatus();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Database successfully updated.");
        } catch (IOException e) {
            System.out.println("Critical Error: Could not write to the database file.");
        }
    }

}
