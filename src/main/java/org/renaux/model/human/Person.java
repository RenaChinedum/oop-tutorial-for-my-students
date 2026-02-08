package org.renaux.model.human;

import lombok.*;
import org.renaux.model.enums.Age;
import org.renaux.model.enums.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public abstract class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Age age;
    private Gender gender;
}
