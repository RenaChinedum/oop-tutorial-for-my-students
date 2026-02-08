package org.renaux.service;

import lombok.RequiredArgsConstructor;
import org.renaux.finance.Transaction;
import org.renaux.finance.Wallet;
import org.renaux.model.PersonRequest;
import org.renaux.model.enums.Age;
import org.renaux.model.enums.Position;
import org.renaux.model.human.externals.Applicant;
import org.renaux.model.human.staff.Staff;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
public class AdminService {

    public static final Map<String, Transaction> listedTransactions = new HashMap<>();
    public static final List<Applicant> listedApplicants = new ArrayList<>();
    public static final List<Staff> listedStaffs = new ArrayList<>();

    public Staff createAdmin(PersonRequest request) {
        Staff admin = new Staff();
        admin.setId(request.getId());
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        admin.setEmail(request.getEmail());
        admin.setPhone(request.getPhone());
        admin.setAddress(request.getAddress());
        admin.setAge(request.getAge());
        admin.setGender(request.getGender());
        admin.setStaffId(request.getStaffId());
        admin.setPosition(Position.ADMINISTRATION);
        admin.setDepartment(request.getDepartment());
        admin.setDateHired(request.getDateHired());
        return admin;
    }

    public void reviewApplications(List<Applicant> applicants) {
        for (Applicant applicant : applicants) {
            if (isAlreadyEmployed(applicant, listedStaffs)) {
                throw new RuntimeException("Applicant with ID " + applicant.getId() + " is already employed.");
            }
            reviewAge(applicant);
            if(isApplyingForAdministrativePosition(applicant)) {
                throw new RuntimeException("Applicants cannot apply for administrative positions.");
            }
            reviewAgeAndPosition(applicant);

            Staff staff = createStaffFromApplicant(applicant);
            listedStaffs.add(staff);
        }
    }

    public void listTransaction() {
        listedTransactions.forEach((s, transaction) -> {
            System.out.println("***********************************");
            System.out.println(listedTransactions.get(s.toString()));
            System.out.println("***********************************");
        });
    }

    public Wallet createStoreWallet() {
        Wallet wallet = new Wallet();
        wallet.setWalletId("STORE_WALLET");
        wallet.setBalance(BigDecimal.ZERO);
        wallet.setCreatedAt(LocalDateTime.now());
        return wallet;
    }

    public Transaction getTransaction(String key) {
        return listedTransactions.get(key);
    }

    private boolean isAlreadyEmployed(Applicant applicant, List<Staff> staffs) {
        return staffs.stream().anyMatch(staff -> staff.getStaffApplicationId().equals(applicant.getId()));
    }

//    private boolean isAlreadyEmployed(Applicant applicant, List<Staff> staffs) {
//        for (Staff staff : staffs) {
//            if (staff.getStaffApplicationId().equals(applicant.getId())) {
//                return true;
//            }
//        }
//        return  false;
//    }


    private void reviewAge(Applicant applicant) {
        if (applicant.getAge().equals(Age.CHILD)) {
            throw new RuntimeException("Applicants under 16 years old are not eligible to apply for a position.");
        }
    }

    private void reviewAgeAndPosition(Applicant applicant) {
        if (applicant.getAge().equals(Age.TEENAGER) && applicant.getPositionAppliedFor().equals(Position.MANAGER.name())) {
            throw new RuntimeException("Teenagers are not eligible to apply for managerial positions.");
        }
    }

    private boolean isApplyingForAdministrativePosition(Applicant applicant) {
        return applicant.getPositionAppliedFor().equals(Position.ADMINISTRATION.name());
    }

    private Staff createStaffFromApplicant(Applicant applicant) {
        Staff staff = new Staff();
        staff.setId(applicant.getId());
        staff.setFirstName(applicant.getFirstName());
        staff.setLastName(applicant.getLastName());
        staff.setEmail(applicant.getEmail());
        staff.setPhone(applicant.getPhone());
        staff.setAddress(applicant.getAddress());
        staff.setAge(applicant.getAge());
        staff.setGender(applicant.getGender());
        staff.setStaffApplicationId(applicant.getApplicationId());
        staff.setPosition(applicant.getPositionAppliedFor());
        staff.setDateHired(LocalDateTime.now());
        staff.setStaffId("STAFF-" + UUID.randomUUID().toString());
        return staff;
    }
}

