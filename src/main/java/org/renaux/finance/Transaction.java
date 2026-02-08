package org.renaux.finance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.renaux.model.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction{
    private String transactionId;
    private String sourceWalletId;
    private String destinationWalletId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private Status transactionStatus;
}
