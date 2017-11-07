public class Appl {

    public static void main(String[] args) {
        Appl appl = new Appl();
        appl.work();
    }

    public void work() {
        Square square = new Square();
        square.setX(2);
        square.setY(3);
        square.setWidth(5);
        System.out.println(square.getPerimeter());
    }
}

class Square {
    private double x, y;
    private double width;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Square() {
    }

    public Square(double x, double y, double width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public double getPerimeter() {
        return 4 * getWidth();
    }
}
