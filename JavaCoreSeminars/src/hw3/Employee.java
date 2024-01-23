package hw3;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

//@Getter
//@Setter
@AllArgsConstructor
//@EqualsAndHashCode
//@ToString
@Data
public class Employee{
    private String FIO;
    private String position;
    private String phone;
    private BigDecimal salary;
    private LocalDate birthDate;


    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    @Override
    public String toString() {

        return String.format("%s - %s , phone - %s ,salary - %s, age - %s", FIO, position, phone, salary, this.getAge());
    }

    public void printInfo() {
        System.out.println(this);
    }

    public void increaseSalary(int value) {
        this.salary = salary.add(BigDecimal.valueOf(value));
    }

    public static boolean compareDates(int year1, int month1, int day1, int year2, int month2, int day2) {
        LocalDate date1 = LocalDate.of(year1, month1, day1);
        LocalDate date2 = LocalDate.of(year2, month2, day2);
        return date1.isBefore(date2);
    }
}
