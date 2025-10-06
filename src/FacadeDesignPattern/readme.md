# Facade Design Pattern

## Overview

The **Facade Design Pattern** is a structural design pattern that provides a simplified interface to a complex subsystem. It hides the complexity of the subsystem and provides a unified interface that makes the subsystem easier to use.

## Definition

The Facade pattern defines a higher-level interface that makes the subsystem easier to use by wrapping a complicated subsystem with a simpler interface.

## Key Characteristics

- **Simplification**: Provides a simple interface to a complex subsystem
- **Decoupling**: Reduces dependencies between clients and subsystem classes
- **Unified Interface**: Combines multiple interfaces into a single, easy-to-use interface
- **Optional**: Clients can still access subsystem classes directly if needed

## When to Use

- When you want to provide a simple interface to a complex subsystem
- When there are many dependencies between clients and implementation classes
- When you want to layer your subsystems
- When you need to wrap a poorly designed collection of APIs with a single well-designed API

## Structure

```
Client → Facade → Subsystem Classes
```

## Implementation Example: Home Theater System

This implementation demonstrates a home theater system where the `HomeTheaterFacade` simplifies the operation of multiple components.

### Class Diagram

```
HomeTheaterFacade
├── Projector
└── SoundSystem
```

### Code Documentation

#### 1. Subsystem Classes

**Projector.java**
```java
package FacadeDesignPattern;

/**
 * Subsystem class representing a projector component
 * Provides basic on/off functionality for the projector
 */
public class Projector {
    /**
     * Turns on the projector
     * Prints status message to console
     */
    public void on() {
        System.out.println("Projector is ON");
    }

    /**
     * Turns off the projector
     * Prints status message to console
     */
    public void off() {
        System.out.println("Projector is OFF");
    }
}
```

**SoundSystem.java**
```java
package FacadeDesignPattern;

/**
 * Subsystem class representing a sound system component
 * Provides basic on/off functionality for the sound system
 */
public class SoundSystem {
    /**
     * Turns on the sound system
     * Prints status message to console
     */
    public void on() {
        System.out.println("Sound System is ON");
    }

    /**
     * Turns off the sound system
     * Prints status message to console
     */
    public void off() {
        System.out.println("Sound System is OFF");
    }
}
```

#### 2. Facade Class

**HomeTheaterFacade.java**
```java
package FacadeDesignPattern;

/**
 * Facade class that provides a simplified interface to the home theater subsystem
 * Encapsulates the complexity of managing multiple components (Projector and SoundSystem)
 * 
 * This facade allows clients to control the entire home theater system with simple commands
 * instead of having to interact with each component individually.
 */
public class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;

    /**
     * Constructor that initializes the facade with required subsystem components
     * 
     * @param projector The projector component
     * @param soundSystem The sound system component
     */
    public HomeTheaterFacade(Projector projector, SoundSystem soundSystem) {
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    /**
     * Turns on the entire home theater system
     * Coordinates the startup of all subsystem components in the correct order
     */
    public void on() {
        projector.on();
        soundSystem.on();
    }

    /**
     * Turns off the entire home theater system
     * Coordinates the shutdown of all subsystem components in the correct order
     */
    public void off() {
        projector.off();
        soundSystem.off();
    }
}
```

#### 3. Client Usage

**Main.java**
```java
package FacadeDesignPattern;

/**
 * Demonstration of the Facade Design Pattern
 * Shows both direct subsystem access and facade-mediated access
 */
public class Main {
    public static void main(String[] args) {
        // Direct access to subsystem components (more complex)
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        projector.on();
        soundSystem.on();

        // Using the Facade (simplified interface)
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, soundSystem);
        homeTheater.on();   // Turns on all components with a single call
        homeTheater.off();  // Turns off all components with a single call
    }
}
```

## Benefits

1. **Simplified Interface**: Clients only need to know about the facade, not the complex subsystem
2. **Loose Coupling**: Reduces dependencies between client code and subsystem classes
3. **Layered Architecture**: Promotes organization of code into layers
4. **Flexibility**: Clients can still access subsystem classes directly if needed

## Drawbacks

1. **God Object**: The facade can become a god object coupled to all classes in the subsystem
2. **Limited Functionality**: May not expose all functionality of the subsystem
3. **Additional Layer**: Adds an extra layer of abstraction

## Real-World Examples

- **Database Access**: ORM frameworks provide facade interfaces to complex database operations
- **Web Services**: API gateways act as facades for multiple microservices
- **Graphics Libraries**: High-level graphics APIs that hide low-level rendering details
- **Operating Systems**: File system APIs that hide the complexity of disk operations

## Comparison with Other Patterns

- **Adapter Pattern**: Adapter changes the interface of an existing class; Facade provides a new interface to a group of classes
- **Decorator Pattern**: Decorator adds functionality; Facade simplifies interface
- **Mediator Pattern**: Mediator manages communication between objects; Facade provides a simplified interface

## Output

When you run the Main class, you'll see:

```
Projector is ON
Sound System is ON
Projector is ON
Sound System is ON
Projector is OFF
Sound System is OFF
```

The first two lines show direct component control, while the last four lines demonstrate the facade controlling all components with simple `on()` and `off()` calls.
