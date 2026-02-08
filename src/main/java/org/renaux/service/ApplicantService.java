package org.renaux.service;

import lombok.RequiredArgsConstructor;
import org.renaux.model.PersonRequest;
import org.renaux.model.human.externals.Applicant;

@RequiredArgsConstructor
public class ApplicantService {

    public void createApplicant(PersonRequest request){
        Applicant applicant = new Applicant();
        applicant.setId(request.getId());
        applicant.setFirstName(request.getFirstName());
        applicant.setLastName(request.getLastName());
        applicant.setEmail(request.getEmail());
        applicant.setPhone(request.getPhone());
        applicant.setAddress(request.getAddress());
        applicant.setGender(request.getGender());
        applicant.setAge(request.getAge());
        applicant.setResume(request.getResume());
        applicant.setCoverLetter(request.getCoverLetter());
        applicant.setPositionAppliedFor(request.getPositionAppliedFor());
        applicant.setApplicationId(request.getApplicationId());
        AdminService.listedApplicants.add(applicant);
        System.out.println("Application created successfully: " + applicant.toString());
    }
}
