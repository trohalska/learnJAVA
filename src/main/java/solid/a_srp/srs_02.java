package solid.a_srp;

public class srs_02 {
    public static void main(String[] args) {
        Student02 student02 = new Student02();
        System.out.println(student02.goLecture());
        Librarian02 librarian02 = new Librarian02();
        System.out.println(librarian02.goLecture());
        Scientist02 scientist02 = new Scientist02();
        System.out.println(scientist02.getGrant());
    }
}

/**
 * correct SOLID - all responsibility in diff classes
 */
class Student02{
    String goLecture(){
        return "Go to Lecture";
    }
}
/**
 * Librarian is also a student
 */
class Librarian02 extends Student02{
    String goLibrary(){
        return "Go to Library";
    }
}
/**
 * Scientist is also a student
 */
class Scientist02 extends Student02{
    int getGrant(){
        return 1000;
    }
}

