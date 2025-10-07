# Flyweight Design Pattern

## What is the Flyweight Design Pattern?

The **Flyweight Design Pattern** is a structural design pattern that helps minimize memory usage when dealing with a large number of objects. It achieves this by sharing common data among multiple objects instead of storing all data in each object.

### Key Concept: "Share to Save Memory"
Think of it like a library system - instead of every person owning every book, people share books from a common library. Similarly, Flyweight shares common object data to reduce memory footprint.

## Core Components

### 1. **Intrinsic State** vs **Extrinsic State**
- **Intrinsic State**: Data that can be shared among objects (stored in flyweight)
- **Extrinsic State**: Data that is unique to each object (passed as parameters)

### 2. **Factory Pattern Integration**
- Uses a factory to manage and reuse flyweight objects
- Maintains a cache/pool of created flyweights

## Code Explanation (Simple Terms)

### Files Overview:

#### 1. `IRobot.java` - The Contract
```java
public interface IRobot {
    public void display( int x, int y );
}
```
**Simple Explanation**: This is like a blueprint that says "any robot must be able to display itself at given coordinates."

#### 2. `Sprite.java` - The Shared Visual Data
```java
public class Sprite {
    String type;
    public Sprite(String type){
        this.type = type;
    }
}
```
**Simple Explanation**: Think of this as the "appearance template" for robots. Multiple robots of the same type can share the same sprite (visual representation).

#### 3. `Robot.java` - The Flyweight Object
```java
public class Robot implements IRobot {
    String robotType; // Intrinsic - shared among robots of same type
    Sprite sprite;    // Intrinsic - shared visual data
    
    public Robot(String robotType, Sprite sprite) {
        this.robotType = robotType;
        this.sprite = sprite;
    }
    
    @Override
    public void display(int x, int y) { // x,y are Extrinsic - unique to each usage
        System.out.println("Robot of type: " + robotType + " at coordinates: " + x + ", " + y);
    }
}
```
**Simple Explanation**: 
- The robot stores shared data (type and sprite) - **Intrinsic State**
- Position (x, y) is passed in when needed - **Extrinsic State**
- This way, all "Humanoid" robots share the same Robot object, but can appear at different positions

#### 4. `RobotFactory.java` - The Memory Saver
```java
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
```
**Simple Explanation**: 
- Acts like a "robot rental service"
- First time someone asks for a "Humanoid" robot → creates and stores it
- Next time someone asks for "Humanoid" → returns the existing one
- **Memory Benefit**: 1000 humanoid robots in a game = only 1 Robot object in memory!

#### 5. `Main.java` - The Demo
```java
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
```
**Simple Explanation**: 
- Creates a 3x3 grid
- Places "Humanoid" robots at even coordinate sums, "Dog" robots at odd sums
- Even though it calls `createRobot()` 9 times, only 2 robot objects are actually created!

## Memory Benefits Demonstration

**Without Flyweight**: 9 robot requests = 9 Robot objects in memory
**With Flyweight**: 9 robot requests = 2 Robot objects in memory (1 Humanoid + 1 Dog)

## When to Use Flyweight Pattern?

✅ **Use When**:
- You need to create a large number of similar objects
- Objects have data that can be shared (intrinsic) vs unique data (extrinsic)
- Memory usage is a concern

❌ **Avoid When**:
- Objects don't have much shared data
- The complexity isn't worth the memory savings
- Objects are frequently modified

## Real-World Examples

1. **Text Editors**: Characters in a document (font, size shared; position unique)
2. **Games**: Trees in a forest (tree model shared; position/rotation unique)
3. **Web Browsers**: CSS styles (style definitions shared; applied elements unique)

## Key Takeaway

**"One template, many instances"** - The Flyweight pattern is like having one cookie cutter (shared template) to make many cookies (instances) at different positions, rather than having a separate cookie cutter for each cookie.
