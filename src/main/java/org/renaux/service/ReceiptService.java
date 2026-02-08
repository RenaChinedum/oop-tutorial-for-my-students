package org.renaux.service;

import lombok.RequiredArgsConstructor;
import org.renaux.finance.Transaction;
import org.renaux.model.business.Receipt;
import org.renaux.model.human.externals.Customer;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ReceiptService {

    public static final List<Receipt> receiptList = new ArrayList<>();

    public void generateReceipt(Transaction transaction, Customer customer) {
        Receipt receipt = new Receipt();
        receipt.setReceiptId("REC-" + (Math.random() * 1000000));
        receipt.setCustomer(customer);
        receipt.setProduct(customer.getCart());
        receiptList.add(receipt);
        System.out.println("***************************************************");
        System.out.println("Receipt ID: " + receipt.getReceiptId());
        System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("****************************************************");
        System.out.println("Product" + " ----------> " + "Price");
        customer.getCart().getProducts().forEach(p ->{
            System.out.println(p.getName() + " ----------> " + p.getPrice());
        });
        System.out.println("Total Amount: " + customer.getCart().getTotal());
        System.out.println("****************************************************");
        System.out.println("Payment Status: " + transaction.getTransactionStatus());
        System.out.println("****************************************************");
        System.out.println("Tanks for shopping with us. We hope to see you again soon!");
    }
}
