package solid.a_srp;

public class srs_03_correct {
    public static void main(String[] args) {
        Librarian03 librarian03 = new Librarian03();
        System.out.println(librarian03.goLecture());
        System.out.println(librarian03.goLibrary());
        Scientist03 scientist03 = new Scientist03();
        System.out.println(scientist03.doScience());
        System.out.println(scientist03.getGrant());
    }
}

/**
 * More correct SOLID - Student is an interface, not a class
 */
interface Student03{
    default String goLecture(){
        return "Go to Lecture";
    }
    int getGrant();
}

class Librarian03 implements Student03{
    String goLibrary(){
        return "Go to Library";
    }

    @Override
    public int getGrant() {
        return 0;
    }
}

class Scientist03 implements Student03{
    String doScience(){
        return "Do the science";
    }

    @Override
    public int getGrant() {
        return 1000;
    }
}
