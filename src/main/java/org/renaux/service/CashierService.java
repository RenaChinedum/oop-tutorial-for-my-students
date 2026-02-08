package org.renaux.service;

import lombok.RequiredArgsConstructor;
import org.renaux.finance.Transaction;
import org.renaux.finance.Wallet;
import org.renaux.model.enums.Position;
import org.renaux.model.human.externals.Customer;
import org.renaux.model.human.staff.Staff;

import java.time.LocalDateTime;

import static org.renaux.model.enums.Status.PENDING;
import static org.renaux.model.enums.Status.SUCCESSFUL;

@RequiredArgsConstructor
public class CashierService {
    private final ReceiptService receiptService;

    public void sellProduct(Customer customer, Staff staff, Wallet storeWallet){
        validateStaffRole(staff);
        validateCustomerWalletBalance(customer);
        Transaction transaction = new Transaction();
        payForProducts(customer, transaction, storeWallet);
        transaction.setTransactionStatus(SUCCESSFUL);
        receiptService.generateReceipt(transaction, customer);
    }


    private static Transaction setTransaction(Customer customer) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId("TXN-" + System.currentTimeMillis());
        transaction.setAmount(customer.getCart().getTotal());
        transaction.setSourceWalletId(customer.getWallet().getWalletId());
        transaction.setDestinationWalletId("STORE_WALLET");
        transaction.setTransactionStatus(PENDING);
        transaction.setTimestamp(LocalDateTime.now());
        return  transaction;
    }

    public void payForProducts(Customer customer, Transaction transaction, Wallet storeWallet){
        Wallet customerWallet = customer.getWallet();
        storeWallet.setBalance(storeWallet.getBalance().add(customer.getCart().getTotal()));
        customerWallet.setBalance(customerWallet.getBalance().subtract(customer.getCart().getTotal()));
        transaction = setTransaction(customer);
        AdminService.listedTransactions.put(customer.getFirstName(), transaction);
    }

    private void validateStaffRole(Staff staff){
        if(!staff.getPosition().equals(Position.CASHIER)){
            throw new IllegalArgumentException("Staff member " + staff.getFirstName() + " " + staff.getLastName() + " does not have the required role to perform this action.");
        }
    }

    private void validateCustomerWalletBalance(Customer customer){
        if(customer.getWallet().getBalance().compareTo(customer.getCart().getTotal()) < 0){
            throw new IllegalArgumentException("Customer " + customer.getFirstName() + " " + customer.getLastName() + " does not have sufficient funds to complete the purchase.");
        }
    }
}
