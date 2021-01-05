package concurrency.synchronizers;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample
{
	// Количество всадников
	private static final int RIDERS_COUNT = 5;
	// Объект синхронизации
    private static CountDownLatch LATCH;
    // Условная длина трассы
    private static final int trackLength = 3000;

    public static class Rider implements Runnable 
    {
        private int riderNumber; // номер всадника
        private int riderSpeed ; // скорость всадника постоянная

        public Rider(int riderNumber, int riderSpeed) 
        {
            this.riderNumber = riderNumber;
            this.riderSpeed  = riderSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Всадник %d вышел к стартовой прямой\n", riderNumber);
                //  Уменьшаем счетчик на 1
                LATCH.countDown();
                
                // Метод await блокирует поток до тех пор, пока счетчик 
                // CountDownLatch не обнулится
                LATCH.await();
                // Ожидание, пока всадник не преодолеет трассу
                Thread.sleep(trackLength / riderSpeed * 10);
                System.out.printf("Всадник %d финишировал\n", riderNumber);
            } catch (InterruptedException e) {
            }
        }
    }
    public static Rider createRider(final int number)
    {
    	return new Rider(number, (int) (Math.random() * 10 + 5));
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        // Определение объекта синхронизации
    	LATCH = new CountDownLatch(RIDERS_COUNT + 3);
        // Создание потоков всадников
        for (int i = 1; i <= RIDERS_COUNT; i++) {
            new Thread(createRider(i)).start(); // new Rider(i, (int) (Math.random() * 10 + 5))).start();
            Thread.sleep(1000);
        }

        // Проверка наличия всех всадников на старте
        while (LATCH.getCount() > 3)
            Thread.sleep(100);

        Thread.sleep(1000);
        System.out.println("На старт!");
        LATCH.countDown();  // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Внимание!");
        LATCH.countDown(); // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Марш!");
        LATCH.countDown(); // Уменьшаем счетчик на 1
        
        // Счетчик обнулен, и все ожидающие этого события потоки разблокированы
    }

}
