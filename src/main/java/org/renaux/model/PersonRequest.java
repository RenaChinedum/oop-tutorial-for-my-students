package org.renaux.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.renaux.model.enums.Age;
import org.renaux.model.enums.Gender;
import org.renaux.model.enums.Position;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Age age;
    private Gender gender;
    private String staffId;
    private Position position;
    private String department;
    private LocalDateTime dateHired;
    private String applicationId;
    private String resume;
    private String coverLetter;
    private Position positionAppliedFor;
}
