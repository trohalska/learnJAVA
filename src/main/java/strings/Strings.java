package strings;

import enums.Weekday;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;

public class Strings {
    /**
     * STRINGS
     * */
    String s = "Hello World!";
    String empty = "";
    String fromClass = new String(new char[] {'H', 'e', 'l', 'l', 'o'});
//    String hello = """
//            cococo
//            thunder
//            ddd
//            """;  // багатострочний ввід

    /** DO NOT USE */
    String newEmptyString = new String();
    String newNonEmptyString = new String("Hello World!");

    /**
     * LOCALE  -  use like in example
     * */
    public void testLocale() {
        String str = "INT";
        String lower = str.toLowerCase(Locale.ENGLISH);  // Locale.ROOT
        System.out.println(lower.equals("int"));
    }

    /**
     * CONVERT CHARS <-> BYTES  -  use like in example
     * */
    public void testConvert() {
        System.out.println(new String(new byte[] {72, 101, 108, 108, 111}, StandardCharsets.UTF_8));
        System.out.println(Arrays.toString("Hello".getBytes(StandardCharsets.UTF_8)));

        /** work with files & locale */
//        Files.newBufferedReader(Paths.get("/etc/passwd"));
//        new FileReader("/etc/passwd", StandardCharsets.UTF_8);
    }

    public void testStringsConcat() {
        String m = "make", j = "java";

        System.out.println(m + ' ' + j);

        /** STRING BUILDER better to use like this */
        StringBuilder allWeekdays = new StringBuilder();
        allWeekdays.append("\n");
        for (Weekday w : Weekday.values()) {
            allWeekdays.append(w).append("\n");
        }
        System.out.println(allWeekdays);

        /** a bit heavy and slow, slower than concat in 10 times*/
        System.out.println(String.format("%s %s", m, j));
        System.out.println(MessageFormat.format("{0} {1} {0}", m, j));

        /** DO NOT USE, TOO SLOW */
        System.out.println(m.concat(" ").concat(j));
        System.out.println(new StringBuilder().append(m).append(" ").append(j));
    }

    public void testStrings() {
        String ss = "Hello World!";
        String st = "  Hello  World !  ";

        System.out.println(ss.startsWith("Hello"));
        System.out.println(ss.endsWith("Hello"));
        System.out.println(ss.contains(" "));
        System.out.println(ss.equalsIgnoreCase("hELLO wORLD!"));
        System.out.println(ss.indexOf('e'));
        System.out.println(ss.indexOf("ll"));
        System.out.println(ss.lastIndexOf("o", 10));
        System.out.println(ss.replace('o', 'a'));
        System.out.println(ss.replace("Hello", "Goodbye"));
        System.out.println(ss.replaceFirst("^Hello", "Goodbye"));
        System.out.println(ss.replaceAll("\\w", "x"));
        System.out.println(st.trim());
        System.out.println(ss.substring(6));
        System.out.println(ss.substring(6, 11));

        String[] spl = ss.split(" ");
        System.out.println(spl[0] + "-*-" + spl[1]);
    }
}
/** METHODS
 *
 *  "Hello World!".startsWith("Hello")                   - чи є у строки потрібний префікс
 *  "Hello World!".endsWith("Hello")                     - ... суфікс
 *  "Hello World!".contains(" ")                       - чи є в складі такі символи
 *  "Hello World!".equalsIgnoreCase("hELLO wORLD!")    - порівняння без врахування lower or upper case
 *  "Hello World!".indexOf('e')                        - індекс входження символа
 *  "Hello World!".indexOf("ll")                       - індекс входження строки
 *  "Hello World!".lastIndexOf("o", 10)                - індекс входження reverse з 10 символа
 *  "Hello World!".replace('o', 'a')                   - заміна
 *  "Hello World!".replace("Hello", "Goodbye")         - заміна
 *  "Hello World!".replaceFirst("^Hello", "Goodbye")   - заміна першого (з regexp)
 *  "Hello World!".replaceAll("\\w", "x")              - заміна симовла (з regexp)
 *  "  Hello  World !  ".trim()                        - трім
 *  "Hello World!".substring(6)                        - копіювання підстроки з 6 символа
 *  "Hello World!".substring(6, 11)                    - копіювання підстроки з 6 до 11 НЕВКЛЮЧНО !!
 *  "Hello World!".split(" ")                          - спліт
 *
 * */