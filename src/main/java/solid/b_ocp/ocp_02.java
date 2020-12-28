package solid.b_ocp;

public class ocp_02 {
    public static void main(String[] args) {
        Tester02 tester02 = new Tester02();
        workInScienceInstitute(tester02);
    }

    /**
     * wrong - fobitten use - instance of, if, etc
     */
    private static void workInScienceInstitute(Scientist02 scientist02){
        scientist02.doScience();
        if(scientist02 instanceof Tester02){
            System.out.println(scientist02.getNotGrant());
        } else {
            System.out.println(scientist02.getGrant());
        }
    }
}

class Scientist02{
    void doScience(){
        System.out.println("Do the science");
    }
    public int getGrant() {
        return 1000;
    }

    public int getNotGrant() {
        return 0;
    }
}

class Tester02 extends Scientist02{
}
