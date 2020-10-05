package strings;

public class StringMain {

    public StringMain() {
        Strings newObj = new Strings();

        System.out.println("------ LOCALE -------");
        newObj.testLocale();

        System.out.println("------ CONVERT -------");
        newObj.testConvert();

        System.out.println("------ STRINGS CONCAT -------");
        newObj.testStringsConcat();

        System.out.println("------ STRING -------");
        newObj.testStrings();
    }
}
