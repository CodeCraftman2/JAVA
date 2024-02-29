public class CarTester {
    public static void main(String[] args) throws Exception {
        Car myCar1 = new Car("Toyota", "Camry");
        Car myCar2 = new Car("Ford", "GT");
        System.out.println("Initial Make and Model of Car 1: " + myCar1.getMake() + " " + myCar1.getModel());
        System.out.println("Initial Make and Model of Car 2: " + myCar2.getMake() + " " + myCar2.getModel());
        myCar2.setMake("Ford");
        myCar2.setModel("Mustang");
        System.out.println("Updated Make and Model of Car 2: " + myCar2.getMake() + " " + myCar2.getModel());
    }
}