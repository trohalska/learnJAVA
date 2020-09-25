package enums;

public enum Weekday {
    MONDAY("MON", false),
    TUESDAY("TUE", false),
    WEDNESDAY("WED", false),
    THURSDAY("THU", false),
    FRIDAY("FRI", false),
    SATURDAY("SAT", true),
    SUNDAY("SUN", true);

    private final String shortName;
    private final boolean weekend;

    Weekday(String shortName, boolean weekend) {
        this.shortName = shortName;
        this.weekend = weekend;
    }

    public String getShortName() {return shortName;}
    public boolean isWeekend() {return weekend;}
}
/** METHODS
 *
 * enumClass.values()        - массив значень
 * enumClass.valueOf(String) - значення по імені або exeption
 * enumValue.name()          - імя (=String)
 * enumValue.ordinal()       - порядковий номер
 *
 * */