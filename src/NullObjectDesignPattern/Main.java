package NullObjectDesignPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Null Object Design Pattern Example");

        Vehical unknownVehical = VehicalFactory.getVehical("Car");
        System.out.println("UnknownVehical has " + unknownVehical.getNumberOfWheels() + " wheels.");

        // As there is no Bike class, it will return NullVehical instance instead of null
        Vehical anotherUnknownVehical = VehicalFactory.getVehical("Bike");
        System.out.println("AnotherUnknownVehical has " + anotherUnknownVehical.getNumberOfWheels() + " wheels.");
    }
}

// Output:
// UnknownVehical has 4 wheels.
// AnotherUnknownVehical has 0 wheels.