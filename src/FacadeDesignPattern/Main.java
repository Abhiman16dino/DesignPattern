package FacadeDesignPattern;

public class Main {
    public static void main(String[] args) {
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        projector.on();
        soundSystem.on();

//        Projector is ON
//        Sound System is ON

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, soundSystem);
        homeTheater.on();
        homeTheater.off();

//        Projector is ON
//        Sound System is ON
//        Projector is OFF
//        Sound System is OFF
    }
}
