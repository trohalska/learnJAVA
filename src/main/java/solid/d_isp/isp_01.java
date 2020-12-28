package solid.d_isp;

public class isp_01 {
    public static void main(String[] args) {
        IWorker01 iWorker01 = new Cook01();
        iWorker01.work();
        iWorker01.eat();
        iWorker01.work();
    }
}

    interface IWorker01{
        void work();
        void eat();
    }

    class Cook01 implements IWorker01{
        @Override
        public void work() {
            System.out.println("work");
        }
        @Override
        public void eat() {
            System.out.println("eat");
        }
    }

