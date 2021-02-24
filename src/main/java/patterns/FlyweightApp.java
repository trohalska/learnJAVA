package patterns;

import java.util.*;

/**
 * с помощью абстрактной фабрики создает один экземпляр класса и переиспользует его когда нужно
 * (вместо штамповки кучи екземпляров классов)
 * фабрика реально создает только три класса, а потом их переиспользует
 */
public class FlyweightApp {
    public static void main(String[] args) {

        FigureFactory figureFactory = new FigureFactory();

        List<Figure> figures = new ArrayList<>();

        figures.add(figureFactory.getFigure("square"));
        figures.add(figureFactory.getFigure("circle"));
        figures.add(figureFactory.getFigure("circle"));
        figures.add(figureFactory.getFigure("point"));
        figures.add(figureFactory.getFigure("square"));
        figures.add(figureFactory.getFigure("circle"));

        Random random = new Random();
        for (Figure f : figures) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            f.draw(x, y);
        }
    }
}

/**
 * FLYWEIGHT
 */
interface Figure {
    void draw(int x, int y);
}
class PointF implements Figure {
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw one point");
    }
}
class CircleF implements Figure {
    int r = 5;
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw circle with radius " + r);
    }
}
class SquareF implements Figure {
    int a = 10;
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw square with side length " + a);
    }
}

/**
 * FLYWEIGHT FACTORY
 */
class FigureFactory {
    private static final Map<String, Figure> figures = new HashMap<>();
    public Figure getFigure(String figureName) {

        Figure figure = figures.get(figureName);
        if (figure == null) {
            switch (figureName) {
                case "circle":
                    figure = new CircleF();
                    break;
                case "square":
                    figure = new SquareF();
                    break;
                case "point":
                    figure = new PointF();
                    break;
            }
            figures.put(figureName, figure);
        }
        return figure;
    }
}