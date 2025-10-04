# Adapter Design Pattern

## What is the Adapter Pattern?
The Adapter Pattern allows incompatible interfaces to work together. It acts as a bridge between two incompatible classes by wrapping one class with another that translates the interface.

## Problem Solved
When you have an existing class with a different interface than what your application expects, the Adapter pattern helps you use that class without modifying its code.

## Real-World Analogy
Think of a power adapter for your laptop when traveling abroad - it adapts the foreign plug format to work with your device.

## Code Example

### Structure
- **PaymentProcessor**: Our application's expected interface
- **PayPalAPI**: Third-party class with incompatible interface  
- **PaymentAdapter**: Adapter that makes PayPalAPI work with PaymentProcessor

### Files Explained

**PaymentProcessor.java** - Target Interface
```java
public interface PaymentProcessor {
    void pay(int amount);
}
```

**PayPalAPI.java** - Existing Third-party Class (Adaptee)
```java
public class PayPalAPI {
    void makePayement(double money) {
        System.out.println("Paying " + money + " using PayPal.");
    }
}
```

**PaymentAdapter.java** - The Adapter
```java
public class PaymentAdapter implements PaymentProcessor {
    PayPalAPI payPalAPI;
    
    public PaymentAdapter(PayPalAPI payPalAPI) {
        this.payPalAPI = payPalAPI;
    }
    
    @Override
    public void pay(int amount) {
        payPalAPI.makePayement((double) amount);
        System.out.println("Payment of " + amount + " processed using PaymentAdapter.");
    }
}
```

**Main.java** - Usage
```java
PaymentProcessor paymentProcessor = new PaymentAdapter(new PayPalAPI());
paymentProcessor.pay(100);
```

### Output
```
Paying 100.0 using PayPal.
Payment of 100 processed using PaymentAdapter.
```

## Key Benefits
1. **Reusability**: Use existing classes without modification
2. **Flexibility**: Integrate third-party libraries easily
3. **Clean Code**: Keep interfaces consistent across your application

## When to Use
- Integrating third-party libraries with different interfaces
- Working with legacy code that can't be modified
- Making incompatible classes work together
