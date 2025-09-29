package StateDesignPattern;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        System.out.println(fan);
        fan.pullString();
        System.out.println(fan);
        fan.pullString();
        System.out.println(fan);
        fan.pullString();
        System.out.println(fan);
    }
}

// Output:
// Fan is in OffMode
// Fan is in OnState
// Fan is in OffMode
// Fan is in OnState
