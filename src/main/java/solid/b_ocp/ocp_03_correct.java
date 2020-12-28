package solid.b_ocp;

public class ocp_03_correct {
    public static void main(String[] args) {
        Tester03 tester03 = new Tester03();
        workInScienceInstitute(tester03);
    }

    private static void workInScienceInstitute(Student03 student03){
        student03.doScience();
        System.out.println(student03.getGrant());
    }
}

/**
 * correct architecture !!!!!
 */
interface Student03{
    default void doScience(){
        System.out.println("Do the science");
    }
    int getGrant();
}

class Scientist03 implements Student03{
    @Override
    public int getGrant() {
        return 1000;
    }
}

class Tester03 implements Student03{
    @Override
    public int getGrant() {
        return 0;
    }
}
