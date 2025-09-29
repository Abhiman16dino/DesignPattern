package StateDesignPattern;

public class OnState implements State {
    @Override
    public void pullString(Fan fan) {
        fan.setState(new OffMode());
    }
}
