package org.renaux.util;

import lombok.experimental.UtilityClass;
import org.renaux.model.PersonRequest;
import org.renaux.model.enums.Age;
import org.renaux.model.enums.Gender;
import org.renaux.model.enums.Position;

import java.util.UUID;

@UtilityClass
public class RequestUtil {
    public static PersonRequest AdminRequest() {
        return PersonRequest.builder()
                .id("ADMIN" + UUID.randomUUID())
                .firstName("Kelechi")
                .lastName("Renaux")
                .age(Age.ADULT)
                .email("admin001@gmail.com")
                .phone("08012345678")
                .address("123 Admin Street, Cityville")
                .staffId("STAFF" + UUID.randomUUID().toString())
                .department("Administration")
                .gender(Gender.MALE)
                .build();
    }

    public static PersonRequest cashierApplicantRequest() {
        return PersonRequest.builder()
                .id("CASHIER" + UUID.randomUUID())
                .firstName("Rita")
                .lastName("Rochas")
                .age(Age.ADULT)
                .email("cashier001@gmail.com")
                .phone("08012345668")
                .address("123 cashier Street, Cityville")
                .department("Administration")
                .gender(Gender.MALE)
                .applicationId("APP" + UUID.randomUUID())
                .resume("Experienced cashier with 5 years in retail.")
                .coverLetter("I am excited to apply for the cashier position at your store")
                .positionAppliedFor(Position.CASHIER)
                .build();
    }

    public static PersonRequest cashierApplicantRequest2() {
        return PersonRequest.builder()
                .id("CASHIER" + UUID.randomUUID())
                .firstName("Cashmere")
                .lastName("Ndilulu")
                .age(Age.ADULT)
                .email("cashier002@gmail.com")
                .phone("08012345668")
                .address("124 cashier Street, Cityville")
                .department("Administration")
                .gender(Gender.FEMALE)
                .applicationId("APP" + UUID.randomUUID())
                .positionAppliedFor(Position.CASHIER)
                .resume("Experienced cashier with 5 years in retail.")
                .coverLetter("I am excited to apply for the cashier position at your store")
                .build();
    }

    public static PersonRequest cashierApplicantRequest3() {
        return PersonRequest.builder()
                .id("MANAGER" + UUID.randomUUID())
                .firstName("ManMark")
                .lastName("Nigga")
                .age(Age.ADULT)
                .email("cashier002@gmail.com")
                .phone("08012345668")
                .address("124 cashier Street, Cityville")
                .department("Administration")
                .gender(Gender.FEMALE)
                .applicationId("APP" + UUID.randomUUID())
                .positionAppliedFor(Position.CASHIER)
                .resume("Experienced cashier with 5 years in retail.")
                .coverLetter("I am excited to apply for the cashier position at your store")
                .build();
    }

    public static PersonRequest CustomerRequest() {
        return PersonRequest.builder()
                .id("CUSTOMER" + UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .age(Age.ADULT)
                .email("customer001@gmail.com")
                .phone("08087654321")
                .address("456 Customer Avenue, Cityville")
                .gender(Gender.MALE)
                .build();
    }

    public static PersonRequest CustomerRequest2() {
        return PersonRequest.builder()
                .id("CUSTOMER" + UUID.randomUUID())
                .firstName("Jane")
                .lastName("Doe")
                .age(Age.ADULT)
                .email("customer001@gmail.com")
                .phone("08087654321")
                .address("456 Customer Avenue, Cityville")
                .gender(Gender.MALE)
                .build();
    }

    public static PersonRequest CustomerRequest3() {
        return PersonRequest.builder()
                .id("CUSTOMER" + UUID.randomUUID())
                .firstName("Emeka")
                .lastName("Don")
                .age(Age.ADULT)
                .email("customer001@gmail.com")
                .phone("08087654321")
                .address("456 Customer Avenue, Cityville")
                .gender(Gender.MALE)
                .build();
    }

}
