package patterns;

/**
 * Адаптер між двома різними классами, у яких не співпадають сигнатури
 * сам нічого не створює, просто коннектить роботу класів
 */
public class AdapterApp {
    public static void main(String[] args) {
        // 1й спосіб - через наслідування
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        // 2й спосіб - через композицію
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
        g2.drawLine();
        g2.drawSquare();

    }
}

/**
 * first class (clients)
 */
interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

/**
 * second class (don't match first one)
 */
class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Draw line...");
    }
    void drawRasterSquare() {
        System.out.println("Draw square...");
    }
}
/**
 * ADAPTER class (two realisations)
 */
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }
    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    RasterGraphics rasterGraphics = new RasterGraphics();
    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }
    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}
