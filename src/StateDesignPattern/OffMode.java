package StateDesignPattern;

public class OffMode implements State {

    @Override
    public void pullString(Fan fan) {
        fan.setState(new OnState());
    }
}
