package exception;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        /*
         * 异常处理：try...catch
         */
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2026/09/17");
            System.out.println(date);

            FileReader file = new FileReader("asdfsaf");
            System.out.println(file);
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }

    }

}
