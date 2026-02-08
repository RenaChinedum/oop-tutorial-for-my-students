package org.renaux.model.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.renaux.model.human.externals.Customer;
import org.renaux.model.human.staff.Staff;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Receipt {
    private String receiptId;
    private Customer customer;
    private Cart product;
    private Staff staff;
}
