package hw4;

import java.time.LocalDate;

public enum Celebrations {
    NEW_YEAR("Новый год", LocalDate.of(1990, 1,1)),
    MARCH8("Международный женский день", LocalDate.of(1990, 3,8), Gender.WOMAN),
    FEBRUARY23("День Защитника Отечества", LocalDate.of(1990, 2,23),  Gender.MAN);

    private String name;
    private LocalDate date;

    private Gender gender;
    Celebrations(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }

    Celebrations(String name, LocalDate date, Gender gender) {
        this.name = name;
        this.date = date;
        this.gender = gender;
    }

    public boolean isForGender(){
        return this.gender != null;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }
}
