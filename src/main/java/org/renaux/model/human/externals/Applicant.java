package org.renaux.model.human.externals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.renaux.model.enums.Position;
import org.renaux.model.human.Person;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends Person {
        private String applicationId;
        private String resume;
        private String coverLetter;
        private Position positionAppliedFor;
}
