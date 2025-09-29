package NullObjectDesignPattern;

public class VehicalFactory {
    public static Vehical getVehical(String vehicalType) {
        if (vehicalType == null) {
            return new NullVehical();
        }
        if (vehicalType.equalsIgnoreCase("Car")) {
            return new Car();
        }
        return new NullVehical();
    }
}
