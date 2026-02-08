package org.renaux.model.human.staff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.renaux.model.enums.Position;
import org.renaux.model.human.Person;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Staff extends Person {
    private String staffId;
    private Position position;
    private String department;
    private LocalDateTime dateHired;
    private String staffApplicationId;
}
