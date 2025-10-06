# Builder Design Pattern

## 📋 Overview

The Builder Design Pattern is a **creational design pattern** that provides a flexible solution for constructing complex objects step by step. It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

## 🎯 Problem It Solves

The Builder pattern addresses several common problems:

1. **Telescoping Constructor Problem**: When you have many optional parameters, you end up with multiple constructors or a constructor with many parameters
2. **Object Immutability**: Creating immutable objects with many fields
3. **Complex Object Creation**: When object creation involves multiple steps or validations
4. **Readability**: Making object creation more readable and maintainable

## 🔧 When to Use Builder Pattern

- When you need to create objects with many optional parameters
- When the object creation process is complex and involves multiple steps
- When you want to create immutable objects
- When you want to provide a fluent interface for object creation

## 💻 Implementation Details

This implementation demonstrates the Builder pattern using a `Student` class with multiple attributes.

### Components

#### 1. Product Class - `Student.java`
```java
// The complex object that needs to be built
public class Student {
    String name;
    int age;
    int roll; // Only required field
    String father;
    String mother;
    
    // Constructor takes builder as parameter
    public Student(StudentBuilder builder) {
        // Initialize fields from builder
    }
}
```

**Key Features:**
- Contains multiple fields (some optional, some required)
- Constructor accepts a builder instance
- Provides a clean toString() method for display

#### 2. Builder Class - `StudentBuilder.java`
```java
// Builder class that constructs Student objects
public class StudentBuilder {
    // Same fields as Student class
    String name;
    int age;
    int roll;
    String father;
    String mother;
    
    // Fluent interface methods
    public StudentBuilder setName(String name) {
        this.name = name;
        return this; // Returns builder for method chaining
    }
    
    // ... other setter methods
    
    // Final build method
    public Student build() {
        return new Student(this);
    }
}
```

**Key Features:**
- **Fluent Interface**: Each setter method returns `this` for method chaining
- **Flexible Construction**: Allows setting any combination of optional parameters
- **Build Method**: Creates and returns the final `Student` object

#### 3. Director Class - `StudentDirector.java`
```java
// Optional director class for common construction patterns
public class StudentDirector {
    public Student createStudent(String name, int age, int roll, String father, String mother) {
        return new StudentBuilder()
                .setName(name)
                .setAge(age)
                .setRoll(roll)
                .setFather(father)
                .setMother(mother)
                .build();
    }
}
```

**Key Features:**
- **Encapsulates Construction Logic**: Provides common construction patterns
- **Simplifies Client Code**: Clients don't need to know the construction steps
- **Reusable**: Can be used for different construction scenarios

#### 4. Client Code - `Main.java`
Demonstrates two ways to use the Builder pattern:

**Method 1: Direct Builder Usage**
```java
Student student = new StudentBuilder()
    .setName("John")
    .setAge(20)
    .setRoll(101)
    .setFather("Doe")
    .setMother("Jane")
    .build();
```

**Method 2: Using Director**
```java
Student student1 = new StudentDirector()
    .createStudent("Alice", 22, 102, "Bob", "Eve");
```

## 🚀 How to Run

1. Navigate to the BuilderDesignPattern directory
2. Compile the Java files:
   ```bash
   javac *.java
   ```
3. Run the main class:
   ```bash
   java Main
   ```

## 📊 Expected Output

```
Student [name=John, age=20, roll=101, father=Doe, mother=Jane]
Student [name=Alice, age=22, roll=102, father=Bob, mother=Eve]
```

## ✅ Advantages

1. **Flexibility**: Can create objects with different combinations of parameters
2. **Readability**: Method names make the code self-documenting
3. **Immutability**: Objects can be made immutable after construction
4. **Validation**: Can add validation logic in the builder
5. **Fluent Interface**: Makes code more readable and intuitive

## ❌ Disadvantages

1. **Code Duplication**: Builder class duplicates fields from the main class
2. **Complexity**: Adds extra classes and complexity for simple objects
3. **Memory Overhead**: Creates additional objects during construction

## 🔄 Builder Pattern Variations

1. **Simple Builder**: Basic implementation (as shown above)
2. **Telescoping Builder**: For handling inheritance
3. **Step Builder**: Enforces a specific order of construction steps
4. **Generic Builder**: Uses generics for type safety

## 🌟 Real-World Examples

- **StringBuilder** in Java
- **HttpClient.Builder** in HTTP libraries
- **AlertDialog.Builder** in Android
- **SQL Query Builders** in ORM frameworks

---

This implementation provides a clean, flexible way to create `Student` objects with various combinations of attributes, demonstrating the power and elegance of the Builder Design Pattern.
