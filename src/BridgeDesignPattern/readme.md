# Bridge Design Pattern

## What is the Bridge Design Pattern?

The Bridge Design Pattern is a **structural design pattern** that separates an abstraction from its implementation so that both can vary independently. Think of it like a bridge that connects two separate hierarchies - one for the abstraction and one for the implementation.

### Real-world Analogy
Imagine you have different types of organisms (fish, humans) and different ways of breathing (through gills, through lungs). Instead of creating separate classes for each combination (FishWithGills, HumanWithLungs), the Bridge pattern lets you mix and match them freely.

## Why Use Bridge Pattern?

1. **Flexibility**: You can change the implementation without affecting the abstraction
2. **Extensibility**: Easy to add new types of organisms or breathing methods
3. **Separation of Concerns**: Keeps abstraction and implementation separate
4. **Avoids Class Explosion**: Instead of creating many subclasses, you compose objects

## Code Structure Explanation

### 1. Implementation Interface (`BreathingMethod.java`)
```java
public interface BreathingMethod {
    void breathe();
}
```
**Simple Explanation**: This is the "bridge interface" that defines what breathing methods can do. Any breathing technique must implement this.

### 2. Concrete Implementations
- **`AirBreathing.java`**: Implements breathing through air/lungs
- **`WaterBreathing.java`**: Implements breathing through water/gills

**Simple Explanation**: These are the actual breathing techniques. You can add more (like `PlantBreathing` for photosynthesis) without changing existing code.

### 3. Abstraction (`Organism.java`)
```java
public class Organism {
    BreathingMethod breathingMethod;
    
    public Organism(BreathingMethod breathingMethod) {
        this.breathingMethod = breathingMethod;
    }
    
    public void performBreathe() {
        breathingMethod.breathe();
    }
}
```
**Simple Explanation**: This is the main abstraction that holds a reference to a breathing method. It doesn't know HOW to breathe, it just delegates to the breathing method.

### 4. Refined Abstractions
- **`LandOrganism.java`**: Represents land-based organisms
- **`WaterOrganism.java`**: Represents water-based organisms

**Simple Explanation**: These are specific types of organisms. They inherit from `Organism` but can have their own special behaviors.

### 5. Usage (`Main.java`)
```java
Organism fish = new WaterOrganism(new WaterBreathing());
Organism human = new LandOrganism(new AirBreathing());

fish.performBreathe();   // Output: Breathing through water gills
human.performBreathe();  // Output: Breathing through Air
```

## Key Benefits Demonstrated

1. **Mixing and Matching**: You could create a `LandOrganism(new WaterBreathing())` - like an amphibian!
2. **Easy Extension**: Add new breathing methods or organism types without modifying existing code
3. **Runtime Flexibility**: You can change an organism's breathing method during runtime

## Memory Aid - "The Bridge Analogy"

Think of the pattern like this:
- **Left Side of Bridge**: Different types of organisms (abstraction hierarchy)
- **Right Side of Bridge**: Different breathing methods (implementation hierarchy)
- **The Bridge**: The interface that connects them (`BreathingMethod`)

The bridge allows any organism to use any breathing method, giving you maximum flexibility!

## When to Use Bridge Pattern

- When you want to avoid permanent binding between abstraction and implementation
- When you need to share an implementation among multiple objects
- When you want to extend classes in two independent dimensions
- When changes in implementation should not impact clients

## Pattern Structure Summary

```
Organism (Abstraction)
    ↓ has-a
BreathingMethod (Implementation Interface)
    ↓ implemented by
AirBreathing, WaterBreathing (Concrete Implementations)
```

The key insight: **Composition over Inheritance** - instead of inheriting breathing behavior, organisms are composed with breathing methods.
