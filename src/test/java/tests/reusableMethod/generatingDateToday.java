package tests.reusableMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class generatingDateToday {

    public static String generatingToday() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(formatter);
        return formattedDate;
    }

}
