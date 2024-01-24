package hw4;

import java.time.LocalDate;

public enum Celebrations {
    NEW_YEAR("Новый год", LocalDate.of(1990, 1,1)),
    MARCH8("Международный женский день", LocalDate.of(1990, 3,8)),
    FEBRUARY23("День Защитника Отечества", LocalDate.of(1990, 2,23)),
    TODAY("Today", LocalDate.now());

    private String name;
    private LocalDate date;
    Celebrations(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
