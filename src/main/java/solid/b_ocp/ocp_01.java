package solid.b_ocp;

public class ocp_01 {
    public static void main(String[] args) {
        Scientist01 scientist01 = new Scientist01();
        workInScienceInstitute(scientist01);
        System.out.println(scientist01.getGrant());
    }

      private static void workInScienceInstitute(Scientist01 scientist01){
        scientist01.doScience();
    }
}

/**
 * wrong OPEN / CLOSED principle
 */
class Scientist01{
    void doScience(){
        System.out.println("Do the science");
    }

    public int getGrant() {
        return 1000;
    }
}
