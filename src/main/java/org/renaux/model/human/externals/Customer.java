package org.renaux.model.human.externals;

import lombok.*;
import org.renaux.finance.Wallet;
import org.renaux.model.business.Cart;
import org.renaux.model.business.Wishlist;
import org.renaux.model.human.Person;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class Customer extends Person {
    private Cart cart;
    private Wishlist wishlist;
    private Wallet wallet;
}
