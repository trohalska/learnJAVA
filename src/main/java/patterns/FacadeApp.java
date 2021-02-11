package patterns;

/**
 * Ми бачимо складну программу через простий класс-фасад (як управління ліфтом через кнопки)
 */

public class FacadeApp {
    public static void main(String[] args) {

//        Power power = new Power();
//        power.on();
//        DVDRom dvd = new DVDRom();
//        dvd.load();
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        Computer computer = new Computer();
        computer.copy();

    }
}

/**
 * Computer class is FACADE
 */
class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("Power on");
    }
    void off() {
        System.out.println("Power off");
    }
}

class DVDRom {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }
    void load() {
        data = true;
    }
    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.println("Data copying in progress...");
        } else {
            System.out.println("Insert dvd with data!");
        }
    }
}