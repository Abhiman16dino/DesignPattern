package BridgeDesignPattern;

public class Main {
    public static void main(String[] args) {
        Organism fish = new WaterOrganism(new WaterBreathing());
        Organism human = new LandOrganism(new AirBreathing());

        fish.performBreathe();
        human.performBreathe();

//        Breathing through water gills
//        Breathing through Air
    }
}
