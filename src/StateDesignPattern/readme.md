# State Design Pattern

## What is the State Design Pattern?

The State Design Pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. It appears as if the object changed its class.

### Key Concepts:
- **Context**: The main object that maintains a reference to a state object
- **State Interface**: Defines the interface for all concrete states
- **Concrete States**: Different states that implement the state interface with specific behaviors

### When to Use:
- When an object's behavior depends on its state
- When you have complex conditional statements based on object state
- When state transitions need to be explicit and controlled

## Real-World Example: Fan Control

Think of a fan with a pull string. Each time you pull the string, the fan changes its state:
- OFF → ON
- ON → OFF

Instead of using if-else conditions, we use different state objects to handle the behavior.

## Code Explanation

### 1. State Interface (`State.java`)
```java
public interface State {
    void pullString(Fan fan);
}
```
- Defines the contract that all states must follow
- Takes a `Fan` object as parameter to allow state transitions

### 2. Context Class (`Fan.java`)
```java
public class Fan {
    private State state;

    public Fan() {
        state = new OffMode();  // Initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pullString() {
        state.pullString(this);  // Delegate to current state
    }
}
```
- Maintains reference to current state
- Delegates behavior to the current state object
- Allows state transitions through `setState()`

### 3. Concrete States

#### OffMode (`OffMode.java`)
```java
public class OffMode implements State {
    @Override
    public void pullString(Fan fan) {
        fan.setState(new OnState());  // Transition to ON state
    }
}
```

#### OnState (`OnState.java`)
```java
public class OnState implements State {
    @Override
    public void pullString(Fan fan) {
        fan.setState(new OffMode());  // Transition to OFF state
    }
}
```

### 4. Demo (`Main.java`)
```java
public static void main(String[] args) {
    Fan fan = new Fan();
    System.out.println(fan);        // Fan is in OffMode
    fan.pullString();
    System.out.println(fan);        // Fan is in OnState
    fan.pullString();
    System.out.println(fan);        // Fan is in OffMode
    fan.pullString();
    System.out.println(fan);        // Fan is in OnState
}
```

## How It Works

1. **Initial State**: Fan starts in `OffMode`
2. **Pull String**: Current state handles the action and transitions to next state
3. **State Change**: Fan's behavior changes based on its current state
4. **No Conditionals**: No if-else statements needed in the Fan class

## Benefits

✅ **Open/Closed Principle**: Easy to add new states without modifying existing code  
✅ **Single Responsibility**: Each state class has one responsibility  
✅ **Eliminates Conditionals**: No complex if-else chains  
✅ **Clear State Transitions**: State changes are explicit and controlled  
✅ **Maintainable**: Easy to understand and modify individual states  

## UML Structure

```
Fan (Context)
├── state: State
├── setState(State)
└── pullString()

State (Interface)
└── pullString(Fan)

OffMode implements State
└── pullString(Fan) → transitions to OnState

OnState implements State
└── pullString(Fan) → transitions to OffMode
```

## Extension Ideas

You can easily extend this pattern by adding more states:
- **LowSpeed**, **MediumSpeed**, **HighSpeed** for a multi-speed fan
- **Timer** states for automatic shut-off
- **Oscillating** states for fan movement

Each new state would implement the `State` interface and define its own transition logic.
