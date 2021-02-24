package patterns;

/**
 * есть контекст, который может менять состояние
 * в зависимости от смены состояния (описанного в классе state) контекст меняет свое поведение
 *
 * конткест имеет три состояния, каждое из которых играет свою музыку
 * при изменении состояния контекста - изменяется поведение контекста
 */
public class StateApp {
    public static void main(String[] args) {

        Radio radio = new Radio();
        Station dfm = new RadioDFM();

        radio.setStation(dfm);

        for (int i = 0; i < 10; ++i) {
            radio.play();
            radio.nextStation();
        }
    }
}

/**
 * STATE
 */
interface Station {
    void play();
}
class Radio7 implements Station {
    public void play() {
        System.out.println("Radio7 is playing...");
    }
}
class RadioDFM implements Station {
    public void play() {
        System.out.println("RadioDFM is playing...");
    }
}
class RadioRock implements Station {
    public void play() {
        System.out.println("RadioRock is playing...");
    }
}

/**
 * CONTEXT
 */
class Radio {
    Station station;
    void setStation(Station station) {
        this.station = station;
    }
    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM) {
            setStation(new RadioRock());
        } else if (station instanceof RadioRock) {
            setStation(new Radio7());
        }
    }
    void play() {
        station.play();
    }
}