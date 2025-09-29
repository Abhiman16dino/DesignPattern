package StateDesignPattern;

public class Fan {
    private State state;

    public Fan() {
        state = new OffMode();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pullString() {
        state.pullString(this);
    }

    @Override
    public String toString() {
        return "Fan is in " + state.getClass().getSimpleName();
    }
}
