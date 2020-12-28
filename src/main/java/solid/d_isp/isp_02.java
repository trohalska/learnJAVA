package solid.d_isp;

public class isp_02 {
    public static void main(String[] args) {
        IWorker02 iWorker02 = new Cook02();
        iWorker02.work();
        iWorker02.eat();
        iWorker02.work();
    }
}

interface IWorker02{
    void work();
    void eat();
}

class Cook02 implements IWorker02 {
    @Override
    public void work() {
        System.out.println("work");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}

class Waiter02 implements IWorker02{

    @Override
    public void work() {
        System.out.println("delivery");
    }

    @Override
    public void eat() {
        // empty
    }
}
