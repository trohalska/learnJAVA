package patterns;

import java.util.Date;

/**
 * фабрика, яка повертає екземпляр конкретного классу
 */
public class FactoryMethodApp {
    public static void main(String[] args) {
//        Watch watch = new DigitalWatch();
//        watch.showTime();
//        Watch watch2 = new RomeWatch();
//        watch2.showTime();

//        WatchMaker maker = new DigitalWatchMaker(); // Rome
//        Watch watch = maker.createWatch();
//        watch.showTime();

        WatchMaker maker = getMakerByName("Rome");
        Watch watch = maker.createWatch();
        watch.showTime();
    }
    public static WatchMaker getMakerByName(String maker) throws RuntimeException {
        if (maker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (maker.equals("Rome")) {
            return new RomeWatchMaker();
        }
        throw new RuntimeException("Invalid maker: " + maker);
    }
}

/**
 * Наші класси - годинник
 */
interface Watch {
    void showTime();
}
class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}
class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

/**
 * Наша фабрика годинників
 */
interface WatchMaker {
    Watch createWatch(); // this is fabric method
}
class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}