# Null Object Design Pattern

## Overview
The Null Object Design Pattern provides a default, do-nothing object in place of a null reference. This avoids null pointer exceptions and simplifies client code by eliminating the need for null checks.

## Implementation in This Project
- **Vehical (Interface):** Defines the contract with a method `getNumberOfWheels()`.
- **Car (Concrete Class):** Implements `Vehical`, returning 4 wheels.
- **NullVehical (Null Object):** Implements `Vehical`, but always returns 0 wheels, representing a non-existent or unknown vehicle.
- **VehicalFactory:** Returns a `Car` if the type is "Car", otherwise returns a `NullVehical` instead of null.
- **Main:** Demonstrates usage. If an unknown type (e.g., "Bike") is requested, the factory returns a `NullVehical`, so calling `getNumberOfWheels()` is safe and returns 0.

## Example Usage
```java
Vehical car = VehicalFactory.getVehical("Car");
System.out.println("Car has " + car.getNumberOfWheels() + " wheels."); // Output: 4

Vehical bike = VehicalFactory.getVehical("Bike");
System.out.println("Bike has " + bike.getNumberOfWheels() + " wheels."); // Output: 0
```

## Benefits
- Avoids null pointer exceptions
- Simplifies client code
- Makes code more robust and readable

