package BridgeDesignPattern;

public class Organism {
    BreathingMethod breathingMethod;
    public Organism(BreathingMethod breathingMethod) {
        this.breathingMethod = breathingMethod;
    }
    public void performBreathe() {
        breathingMethod.breathe();
    }
}
