package solid.a_srp;

public class srs_04_facade_pattern {
    public static void main(String[] args) {
        FacadeStudent04 facadeStudent04 = new FacadeStudent04();
        System.out.println(facadeStudent04.goLecture());
        System.out.println(facadeStudent04.goLibrary());
        System.out.println(facadeStudent04.doScience());
        System.out.println(facadeStudent04.getGrantScientist());
    }
}

/**
 * Facade pattern in use
 * under pattern - create different class by demand
 */
class FacadeStudent04{
    private Librarian04 librarian04 = new Librarian04();
    private Scientist04 scientist04 = new Scientist04();
    String goLecture(){
        return  librarian04.goLecture();
    }

    String goLibrary(){
        return librarian04.goLibrary();
    }

    String doScience(){
        return scientist04.doScience();
    }

    int getGrantScientist() {
        return scientist04.getGrant();
    }
}

interface Student04{
    default String goLecture(){
        return "Go to Lecture";
    }
    int getGrant();
}

class Librarian04 implements Student04{
    String goLibrary(){
        return "Go to Library";
    }

    @Override
    public int getGrant() {
        return 0;
    }
}

class Scientist04 implements Student04{
    String doScience(){
        return "Do the science";
    }

    @Override
    public int getGrant() {
        return 1000;
    }
}
