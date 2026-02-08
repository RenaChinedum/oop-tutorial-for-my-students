package org.renaux.service;

import lombok.RequiredArgsConstructor;
import org.renaux.finance.Wallet;
import org.renaux.model.human.externals.Customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class WalletService {

    public Wallet createWallet(String customerId) {
       return Wallet.builder()
               .walletId(customerId)
               .balance(BigDecimal.ZERO)
               .createdAt(LocalDateTime.now())
               .build();
    }

    public void fundwallet(Customer customer, double amount) {
        Wallet wallet = customer.getWallet();
        wallet.setBalance(wallet.getBalance().add(BigDecimal.valueOf(amount)));
        System.out.println("Wallet that funded successfully. Current balance: " + wallet.getBalance());
    }
}
