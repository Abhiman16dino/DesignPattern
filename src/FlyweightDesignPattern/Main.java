package FlyweightDesignPattern;

public class Main {
    public static void main(String[] args) {

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if((i+j)%2 == 0){
                    IRobot robot = RobotFactory.createRobot("Humanoid");
                    robot.display(i, j);
                } else {
                    IRobot robot = RobotFactory.createRobot("Dog");
                    robot.display(i, j);
                }
            }
        }
    }
}
