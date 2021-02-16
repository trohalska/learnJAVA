package patterns;

/**
 * допомагає позбутися дублювання кода,
 * шляхом створення абстрактного класса, який має в собі код що дублюється,
 * від нього наслідуються кінцеві
 * (схожий на декоратор і композицію)
 */
public class TemplateMethodApp {
    public static void main(String[] args) {
//        AA a = new AA();
//        a.method();
//        System.out.println();
//        BB b = new BB();
//        b.method();

        Template a = new AA();
        a.templateMethod();
        System.out.println();
        Template b = new BB();
        b.templateMethod();
    }
}

/**
 * start
 */
//class AA extends Template {
//    void differ() {
//        System.out.println("1");
//        System.out.println("2");
//        System.out.println("3");
//    }
//}
//class BB {
//    void method() {
//        System.out.println("1");
//        System.out.println("4");
//        System.out.println("3");
//    }
//}

/**
 * fixed with template method pattern
 */
abstract class Template {
    void templateMethod() {
        System.out.print("1");
        differ();
        System.out.print("3");
        differ2();
    }
    abstract void differ();
    abstract void differ2();
}

class AA extends Template {
    void differ() {
        System.out.print("2");
    }
    void differ2() {
        System.out.print("5");
    }
}
class BB extends Template {
    void differ() {
        System.out.print("4");
    }
    void differ2() {}
}
