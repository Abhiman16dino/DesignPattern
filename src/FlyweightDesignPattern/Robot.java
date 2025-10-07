package FlyweightDesignPattern;

public class Robot implements IRobot {
    String robotType; // Extrinsic
    Sprite sprite; // Extrinsic


    public Robot(String robotType, Sprite sprite) { // Intrinsic
        this.robotType = robotType;
        this.sprite = sprite;
    }

    @Override
    public void display(int x, int y) { // Extrinsic
        System.out.println("Robot of type: " + robotType + " at coordinates: " + x + ", " + y);
    }
}
