package hw3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivan Petrov",
                "devops",
                "+79765463452",
                BigDecimal.valueOf(100000),
                LocalDate.of(1993, 1, 1));

        Employee employee2 = new Employee("Vasiliy Petrov",
                "programmer",
                "+79765463452",
                BigDecimal.valueOf(200000),
                LocalDate.of(1965, 1, 1));

        Employee employee3 = new Employee("Ivan Ivanov",
                "engineer",
                "+79765463452",
                BigDecimal.valueOf(60000),
                LocalDate.of(1980, 1, 1));

        Employee employee4 = new Employee("Ivan Sidorov",
                "analyst",
                "+79765463452",
                BigDecimal.valueOf(50000),
                LocalDate.of(1990, 1, 1));

        Employee employee5 = new Employee("Petr Petrov",
                "team lead",
                "+79765463452",
                BigDecimal.valueOf(300000),
                LocalDate.of(1975, 1, 1));


        List<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, employee4, employee5));

        for (Employee employee : employees) {
            employee.printInfo();
        }

        System.out.println(getAverageSalaryAndAge(employees));

        System.out.println("-----------------------------------");

        System.out.println(Employee.compareDates(
                employee1.getBirthDate().getYear(),
                employee1.getBirthDate().getMonthValue(),
                employee1.getBirthDate().getDayOfMonth(),
                employee2.getBirthDate().getYear(),
                employee2.getBirthDate().getMonthValue(),
                employee2.getBirthDate().getDayOfMonth()
                ));

        Manager manager1 = new Manager("Bruce Wayne",
                "owner",
                "123445",
                BigDecimal.valueOf(1_000_000),
                LocalDate.of(1972, 2, 19));

        Manager manager2 = new Manager("Tony Stark",
                "owner",
                "456123",
                BigDecimal.valueOf(1_000_000),
                LocalDate.of(1970, 5, 29));

        employees.add(manager1);
        employees.add(manager2);
        showList(employees);
        System.out.println();

        Manager.salaryIncreaseForEmployees(employees, 5);

        showList(employees);

    }

    public static void showList(List<Employee> list){
        for (Employee employee : list) {
            employee.printInfo();
        }
    }

    public static String getAverageSalaryAndAge(List<Employee> employees) {
        double averageSalaries = employees.stream().mapToDouble(x -> x.getSalary().doubleValue()).average().orElseThrow();
        double averageAge = employees.stream().mapToDouble(x -> (double) x.getAge()).average().orElseThrow();

        return String.format("Average salary - %s, age - %s", averageSalaries, averageAge);

    }

    public static AverageResponseDTO getAverage(List<Employee> employees) {
        return AverageResponseDTO.builder()
                .averageAge(employees.stream().mapToDouble(x -> (double) x.getAge()).average().orElseThrow())
                .averageSalary(employees.stream().mapToDouble(x -> x.getSalary().doubleValue()).average().orElseThrow())
                .averageLettersInFIO((int) employees.stream().mapToInt(x -> x.getFIO().length()).average().orElseThrow())
                .build();
    }
}
