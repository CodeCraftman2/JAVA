import java.util.Scanner;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rectangle rc = new Rectangle();

        System.out.print("Enter the width of the rectangle: ");
        rc.setWidth(sc.nextDouble());

        System.out.print("Enter the height of the rectangle: ");
        rc.setHeight(sc.nextDouble());

        System.out.println("Rectangle:");
        System.out.println("Width: " + rc.getWidth());
        System.out.println("Height: " + rc.getHeight());
        System.out.println("Area: " + rc.getArea());
        System.out.println("Perimeter: " + rc.getPerimeter());

        sc.close();
    }
}