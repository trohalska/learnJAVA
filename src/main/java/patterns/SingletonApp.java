package patterns;

/**
 * Створюється тільки один екземпляр класса,
 * при спробі створити щне один - повертається ссилка на існуючий.
 *
 * - приватний конструктор не дає використовувати new для штампування екземплярів;
 * - private static Singleton instance - всередині класса створюється екземпляр класса для видачі назовні;
 * - public static Singleton getInstance() - створює екземляр якщо null, і повертає ссилку якщо уже створений одинж
 */
public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        int SIZE = 1000;

        Thread[] t = new Thread[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for (int i = 0; i < SIZE; ++i) {
            t[i].join();
        }
        System.out.println(Singleton.counter);
    }

}

class R implements Runnable {
    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton {
    public static int counter = 0;
    private Singleton() {
        counter++;
    }

    /**  проблема - не працює в багатопоточності  */
//    private static Singleton instance;
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**  потокобезпечний варіант
     * проблема - немає лінивої ініціації (за вимогою), ініціюється при компіляції */
//    private static Singleton instance = new Singleton();
//    public static Singleton getInstance() {
//        return instance;
//    }

    /**  потокобезпечний варіант
     * проблема - стопорить всі потоки, які запросять цей класс */
//    private static Singleton instance = null;
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**  потокобезпечний варіант, все круто, стопоряться тільки перші пару потоків,
     * які борються за ініціалізацію классу, інші отримують тільки екземпляр*/
    private static volatile Singleton instance = null;
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
