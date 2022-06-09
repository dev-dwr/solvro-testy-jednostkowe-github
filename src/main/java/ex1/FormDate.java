package ex1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormDate {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

    public static String formDateToString(LocalDate date){
        return date.format(dateTimeFormatter);
    }

}
