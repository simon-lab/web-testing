package tests.reusableMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class generatingDateToday {

    public static String generatingToday() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(formatter);
        return formattedDate;
    }

    public static String generatingTodayTextFormat() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        return today.format(formatter);
    }

}
