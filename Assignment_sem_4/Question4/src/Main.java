import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter laptop model: ");
        String model = sc.nextLine();

        System.out.print("Enter laptop price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.println("Laptop Model: " + model + ", Laptop Price: $" + price);

        Laptop laptop = new Laptop();

        laptop.setModel(model);

        System.out.print("Enter new laptop model: ");
        model = sc.nextLine();

        laptop.setModel(model);

        System.out.print("Enter new laptop price: ");
        price = sc.nextDouble();
        sc.nextLine();

        laptop.setPrice(price);

        System.out.println(laptop);

        sc.close();
    }
}
