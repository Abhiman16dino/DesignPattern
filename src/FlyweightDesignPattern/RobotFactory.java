package FlyweightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    private static Map<String, IRobot> roboCache = new HashMap<String, IRobot>();

    public static IRobot createRobot(String robotType){
        IRobot robot = roboCache.get(robotType);
        if (robot == null){
            Sprite sprite = new Sprite(robotType);
            robot = new Robot(robotType, sprite);
            roboCache.put(robotType, robot);
            System.out.println("Creating robot of type: " + robotType);
        }
        return robot;
    }
}
