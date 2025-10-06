package FacadeDesignPattern;

public class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(Projector projector, SoundSystem soundSystem) {
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void on() {
        projector.on();
        soundSystem.on();
    }

    public void off() {
        projector.off();
        soundSystem.off();
    }
}
