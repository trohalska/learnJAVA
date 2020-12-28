package solid.d_isp;

public class isp_03_correct {
    public static void main(String[] args) {
        IWorker03 iWorker03 = new Cook03();
        iWorker03.work();
        iWorker03.eat();
        iWorker03.work();
        Worker03 waiter03 = new Waiter03();
        waiter03.work();

    }
}

/**
 * correct interface segregation!!
 */
interface Worker03{
    void work();
}
interface Eater03{
    void eat();
}
interface IWorker03 extends Worker03, Eater03{
}
class Cook03 implements IWorker03 {
    @Override
    public void work() {
        System.out.println("work");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}
class Waiter03 implements Worker03{
    @Override
    public void work() {
        System.out.println("delivery");
    }
}

