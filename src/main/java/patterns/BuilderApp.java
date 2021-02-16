package patterns;

public class BuilderApp {
    public static void main(String[] args) {
        // SIMPLE BUILDER

//        Car car = new CarBuilder()
//                .make("Mercedes")
//                .transmission(Transmission.AUTO)
//                .maxSpeed(280)
//                .build();
//        System.out.println(car);
//
//        Car def = new CarBuilder().build();
//        System.out.println(def);

        Director director = new Director();
//        director.setBuilder(new SubaruBuilder());
        director.setBuilder(new FordMondeoBuilder());

        Car car = director.BuildCar();
        System.out.println(car);

    }
}

enum Transmission {
    MANUAL, AUTO
}
class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

abstract class CarBuilder {
    Car car;
    void createCar() { car = new Car(); }

    abstract void make();
    abstract void transmission();
    abstract void maxSpeed();

    Car getCar() {return car;}
}

class FordMondeoBuilder extends CarBuilder {
    void make() {
        car.setMake("Ford Mondeo");
    }
    void transmission() {
        car.setTransmission(Transmission.AUTO);
    }
    void maxSpeed() {
        car.setMaxSpeed(260);
    }
}
class SubaruBuilder extends CarBuilder {
    void make() {
        car.setMake("Ford Subaru");
    }
    void transmission() {
        car.setTransmission(Transmission.MANUAL);
    }
    void maxSpeed() {
        car.setMaxSpeed(320);
    }
}

/**
 * використовує будь-який білдер, який задається сеттером
 */
class Director {
    CarBuilder builder;
    void setBuilder(CarBuilder b) { builder = b; }

    Car BuildCar() {
        builder.createCar();
        builder.make();
        builder.transmission();
        builder.maxSpeed();
        Car car = builder.getCar();
        return car;
    }
}


//class CarBuilder {
//    String make = "Default";
//    Transmission transmission = Transmission.MANUAL;
//    int maxSpeed = 120 ;
//
//    CarBuilder make(String make) {
//        this.make = make;
//        return this;
//    }
//    CarBuilder transmission(Transmission transmission) {
//        this.transmission = transmission;
//        return this;
//    }
//    CarBuilder maxSpeed(int maxSpeed) {
//        this.maxSpeed = maxSpeed;
//        return this;
//    }
//
//    Car build() {
//        Car car = new Car();
//        car.setMake(make);
//        car.setTransmission(transmission);
//        car.setMaxSpeed(maxSpeed);
//        return car;
//    }
//}