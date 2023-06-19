package CaseStudy.Utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtils {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public static String formatLocalDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return formatter.format(localDate);
    }
    public static LocalDate parseStrLocalDate(String strLocalDate) throws DateTimeParseException {
        return LocalDate.parse(strLocalDate, formatter);
    }
    public static boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return date.isAfter(startDate) && date.isBefore(endDate);
    }
    public static boolean isDate1InRange(Date date, Date startDate, Date endDate) {
        return date.after(startDate) && date.before(endDate);
    }

    private static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";
    public static Date parseStrToDate(String dateStr, String format) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Date parseStrToDate(String dateStr) {
        return parseStrToDate(dateStr, DEFAULT_DATE_FORMAT);
    }
}

