package patterns;

/**
 * Підставляє себе замість викоритсовуваного класса
 * Приклад відкоаденої загрузки - коли картинка підгружається тоді,
 * коли вона реально проглядається
 * remote proxy - приховує роботу в мережі (клієнт бачить обєкт як локальний, а обєкт - на віддаленому сервері)
 * virtual proxy - відкладує створення до моменту реального проглядання
 * protection proxy - допомагає визначати доступ (чи може клієнт викликати цей метод?)
 */
public class ProxySurrogateApp {
    public static void main(String[] args) {
//        Image image = new RealImage("dino.png");          ----> loading
//        image.display();                                  ----> watching

        Image image = new ProxyImage("dino.png");  //   ---->
        image.display();                                // ----> loading & watching
    }
}

interface Image {
    void display();
}
/** REAL USER CLASS */
class RealImage implements Image {
    String file;
    public RealImage(String file) {
        this.file = file;
        load();
    }
    private void load() {
        System.out.println("Loading " + file);
    }
    public void display() {
        System.out.println("Watching " + file);
    }
}

/**  PROXY  */
class ProxyImage implements Image {
    String file;
    RealImage image;   // -------> this is reference in proxy to real class

    public ProxyImage(String file) {
        this.file = file;
    }
    public void display() {
        if (image == null) {
            image = new RealImage(file);
        }
       image.display();
    }
}