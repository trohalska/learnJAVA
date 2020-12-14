package enums;

public class EnumMainPlanets {
    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println(Planet.JUPITER.name());
        System.out.println(Planet.JUPITER.mass());
        System.out.println(Planet.JUPITER.radius());
        System.out.println(Planet.JUPITER);
        System.out.println(Planet.JUPITER.surfaceGravity());
        System.out.println("==============================");
        for (Planet planet : Planet.values()) {
            System.out.println(planet);
        }
        System.out.println("==============================");
        for (Planet planet : Planet.values()) {
            System.out.println(planet.name() + " " + planet.mass());
        }

        System.out.println("==============================");
        for (Planet p : Planet.values()) {
            System.out.print(p.name().charAt(0) +
                p.name().substring(1).toLowerCase() + " ");
        }

    }
}
