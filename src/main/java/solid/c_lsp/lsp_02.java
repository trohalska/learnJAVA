package solid.c_lsp;

public class lsp_02 {
    static Rectangle02 getRectangle(){
        return new Square02();
    }

    public static void main(String[] args) {
        Rectangle02 rectangle02 = getRectangle();
        rectangle02.setHeight(5);
        rectangle02.setWidth(7);
        System.out.println(rectangle02.getSquare());
    }
}

class Rectangle02{
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

class Square02 extends Rectangle02{
    public void setWidth(int width) {
        this.height = this.width = width;
    }
    public void setHeight(int height) {
        this.height = this.width = height;
    }
}
