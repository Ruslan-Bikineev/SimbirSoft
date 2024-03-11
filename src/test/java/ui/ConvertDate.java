package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertDate {
    public String swapDayAndMonth(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.ENGLISH);
        try {
            Date dateFormat = formatter.parse(date);
            SimpleDateFormat newFormatter = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a", Locale.ENGLISH);
            date = newFormatter.format(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
