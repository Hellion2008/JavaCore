package hw3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Manager extends Employee{
    public Manager(String FIO, String position, String phone, BigDecimal salary, LocalDate birthDate) {
        super(FIO, position, phone, salary, birthDate);
    }

    public static void salaryIncreaseForEmployees(List<Employee> employees, int bonusValue) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                employee.increaseSalary(bonusValue);
            }
        }
    }
}
