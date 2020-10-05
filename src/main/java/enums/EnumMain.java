package enums;

//import enum Weekday;

public class EnumMain {
    public EnumMain() {
        for (Weekday w : Weekday.values()) {
            System.out.println(w + " (" + w.getShortName() + ")\t" +
                    (w.isWeekend() ? "relax and enjoy" : "arbeiten!"));
        }

        System.out.println(Weekday.values());
//        System.out.println(Weekday.valuesOf(Weekday.MONDAY).toString());
        System.out.println(Weekday.MONDAY.name());      // MONDAY
        System.out.println(Weekday.TUESDAY.ordinal());  // 1
    }

}

/** METHODS
 *
 * enumClass.values()        - массив значень
 * enumClass.valueOf(String) - значення по імені або exeption
 * enumValue.name()          - імя (=String)
 * enumValue.ordinal()       - порядковий номер
 *
 * */
