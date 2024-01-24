package hw4;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Customer {
    private String FIO;
    private LocalDate dateOfBirth;
    private String phone;

    private Gender gender;

    public Customer(String FIO, LocalDate dateOfBirth, String phone, Gender gender) {
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
    }

//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
}
