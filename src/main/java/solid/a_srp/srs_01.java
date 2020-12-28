package solid.a_srp;

public class srs_01 {
    public static void main(String[] args) {
        Student01 student01 = new Student01();
        System.out.println(student01.goLecture());
        System.out.println(student01.getGrant());
        System.out.println(student01.goLibrary());
    }
}

/**
 * wrong SOLID - all functionality in one class
 */
class Student01{
    String goLecture(){
        return "Go to Lecture";
    }
    String goLibrary(){
        return "Go to Library";
    }
    int getGrant(){
        return 1000;
    }
}
