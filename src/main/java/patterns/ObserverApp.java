package patterns;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * наблюдаемый обьект может изменить свое состояние,
 * тогда наблюдатель реагирует и уведомляет всех об изменении
 */
public class ObserverApp {
    public static void main(String[] args) {

        MeteoStation station = new MeteoStation();

        station.addObserver(new ConsoleObserver());
        station.addObserver(new ConsoleObserver());
//        station.addObserver(new FileObserver());

        station.setMeasurements(25, 760);
        station.setMeasurements(27, 780);
    }
}
interface Observed {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
/**
 * НАБЛЮДАЕМЫЙ класс
 */
class MeteoStation implements Observed {
    int temperature;
    int pressure;
    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p) {
        temperature = t;
        pressure = p;
        notifyObserver();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObserver() {
        for (Observer o : observers){
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer {
    void handleEvent(int t, int p);
}

/**
 * НАБЛЮДАТЕЛЬ
 */
class ConsoleObserver implements Observer {
    public void handleEvent(int t, int p) {
        System.out.println("Weather is change. Temperature: " + t + ", pressure: " + p);
    }
}
// files in dir /tmp
//class FileObserver implements Observer {
//    public void handleEvent(int t, int p) {
//        File f;
//        try {
//            f = File.createTempFile("TempPressure", "_txt");
//            PrintWriter pw = new PrintWriter(f);
//            pw.println("Weather is change. Temperature: " + t + ", pressure: " + p);
//            pw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
