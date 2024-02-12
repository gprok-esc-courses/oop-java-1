package cars;

public class CarRental {
    public static void main(String[] args) {
        Car a = new Car("AZB6723", 1000);
        Car b = new Car("AOO9011", 2500);
        Car c = new Car();
        Car d = a;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
