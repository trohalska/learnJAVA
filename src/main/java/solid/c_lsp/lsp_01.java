package solid.c_lsp;

public class lsp_01 {
    static Rectangle01 getRectangle(){
        return new Rectangle01();
    }

    public static void main(String[] args) {
        Rectangle01 rectangle01 = getRectangle();
        rectangle01.setHeight(5);
        rectangle01.setWidth(7);
        System.out.println(rectangle01.getSquare());
    }
}

/**
 * wrong leskov
 */
class Rectangle01{
    int width;
    int height;

    public int getSquare(){
        return  width*height;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
