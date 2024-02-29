import java.util.Scanner;

public class Point {
    private int x;
    private int y;

    // Parameterized constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Copy constructor
    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


            System.out.print("Enter the X value for the first Point object: ");
            int xValue = sc.nextInt();

            System.out.print("Enter the Y value for the first Point object: ");
            int yValue = sc.nextInt();


            Point p1 = new Point(xValue, yValue);

            System.out.println("Original Point1: (" + p1.getX() + ", " + p1.getY() + ")");


            System.out.print("Enter the new X value for the first Point object: ");
            int newXValue = sc.nextInt();

            System.out.print("Enter the new Y value for the first Point object: ");
            int newYValue = sc.nextInt();

            p1.setX(newXValue);
            p1.setY(newYValue);

            Point p2 = new Point(p1);

            System.out.println("Modified Point2: (" + p2.getX() + ", " + p2.getY() + ")");

            sc.close();
        }
    }