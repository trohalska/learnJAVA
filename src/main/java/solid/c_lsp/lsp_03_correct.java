package solid.c_lsp;

public class lsp_03_correct {
/*    static Shape03 getShape(){
        Rectangle03 rectangle03 = new Rectangle03();
        rectangle03.setHeight(5);
        rectangle03.setWidth(7);
        return rectangle03;
    }*/

    static Shape03 getShape(){
        Square03 square03 = new Square03();
        square03.setWidth(7);
        return square03;
    }


    public static void main(String[] args) {
        Shape03 shape03 = getShape();
        System.out.println(shape03.getSquare());
    }
}

/**
 * correct barbara leskov principle
 */
interface Shape03{
    int getSquare();
}

class Rectangle03 implements Shape03{
    int width;
    int height;

    @Override
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

class Square03 implements Shape03{
    int width;

    @Override
    public int getSquare(){
        return  width*width;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
}

