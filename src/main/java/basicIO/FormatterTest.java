package basicIO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatterTest {
    public static void main(String[] args) throws ParseException {

        // %[argument_index$][flags][width][.precision]conversion
        String name = "User";
        System.out.printf("%s : %s %1$s%n", name, new Date());
        System.out.printf("Your name: |%10s|%n", name);
        System.out.printf("Your name: |%-10s|%n", name);
        String s1 = String.format("Duke's Birthday: %1$td--%1$tm--%1$tY", new Date());
		String s2 = String.format("%1$s's Birthday: %2$tm %<te,%<tY", name, new Date());
        System.out.println(s1);
		System.out.println(s2);
		System.out.printf("%04x%n", 31);
//
        SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yy");
        System.out.println(sdf.parse("05.06.80"));
    }
}
