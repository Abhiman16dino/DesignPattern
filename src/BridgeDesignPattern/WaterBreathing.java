package BridgeDesignPattern;

public class WaterBreathing implements BreathingMethod{
    @Override
    public void breathe() {
        System.out.println("Breathing through water gills");
    }
}
