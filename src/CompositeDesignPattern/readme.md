# Composite Design Pattern

**Author:** Implementation by Abhishek Mondal  
**Date:** October 4, 2025  
**Pattern Category:** Structural Design Pattern

## 📋 Table of Contents
1. [What is Composite Design Pattern?](#what-is-composite-design-pattern)
2. [Problem Statement](#problem-statement)
3. [Solution](#solution)
4. [Key Components](#key-components)
5. [Implementation Details](#implementation-details)
6. [Code Walkthrough](#code-walkthrough)
7. [When to Use](#when-to-use)
8. [Advantages & Disadvantages](#advantages--disadvantages)
9. [Real-World Examples](#real-world-examples)

## What is Composite Design Pattern?

The **Composite Design Pattern** is a structural design pattern that allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.

> **Key Concept:** "Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly."

## Problem Statement

Imagine you're building a file system where you have:
- **Files** (leaf nodes) - cannot contain other files
- **Folders** (composite nodes) - can contain files and other folders

**The Challenge:**
- How do you treat files and folders uniformly?
- How do you perform operations (like listing contents) on both individual files and entire folder hierarchies?
- How do you avoid complex conditional logic based on object types?

## Solution

The Composite pattern solves this by:
1. **Common Interface:** Both files and folders implement the same interface
2. **Uniform Treatment:** Client code doesn't need to distinguish between files and folders
3. **Recursive Structure:** Folders can contain both files and other folders seamlessly

## Key Components

### 1. Component (FileSystem.java)
```java
public interface FileSystem {
    void ls();  // Common operation for both files and folders
}
```
- **Purpose:** Defines the common interface for all objects in the composition
- **Role:** Declares operations that are common to both simple and complex objects

### 2. Leaf (File.java)
```java
public class File implements FileSystem {
    private final String name;
    
    public File(String name) {
        this.name = name;
    }
    
    @Override
    public void ls() {
        System.out.println("File: " + name);
    }
}
```
- **Purpose:** Represents leaf objects (endpoints) in the composition
- **Characteristics:** 
  - Has no children
  - Implements basic behavior of the component
  - Cannot add/remove other components

### 3. Composite (Folder.java)
```java
public class Folder implements FileSystem {
    private final List<FileSystem> fileSystems;
    private final String name;
    
    public Folder(String name) {
        this.name = name;
        this.fileSystems = new ArrayList<>();
    }
    
    public void add(FileSystem fs) {
        fileSystems.add(fs);
    }
    
    @Override
    public void ls() {
        System.out.println("Folder: " + name);
        for(FileSystem fs : fileSystems) {
            fs.ls();  // Recursive call - key to the pattern!
        }
    }
}
```
- **Purpose:** Represents complex objects that can have children
- **Characteristics:**
  - Can contain other components (files or folders)
  - Implements operations by delegating to child components
  - Manages child components through add/remove operations

## Implementation Details

### Tree Structure Created in Main.java:
```
Downloads/                    <- Root Folder (Composite)
├── 1.jpg                    <- File (Leaf)
├── 2.jpg                    <- File (Leaf)
├── 3.jpg                    <- File (Leaf)
└── Movies/                  <- Sub-folder (Composite)
    ├── avengers.mp4         <- File (Leaf)
    └── BigHero6.mp4         <- File (Leaf)
```

### Execution Flow:
1. **Create root folder:** `new Folder("Downloads")`
2. **Add files to root:** Files are added directly to the Downloads folder
3. **Create subfolder:** `new Folder("Movies")`
4. **Add files to subfolder:** Files are added to the Movies folder
5. **Add subfolder to root:** The Movies folder becomes a child of Downloads
6. **Execute ls():** Recursively lists all contents

## Code Walkthrough

### Step-by-Step Execution of `folder.ls()`:

1. **Initial Call:** `Downloads.ls()`
   - Prints: "Folder: Downloads"
   - Iterates through children: [1.jpg, 2.jpg, 3.jpg, Movies/]

2. **First Iteration:** `1.jpg.ls()`
   - Prints: "File: 1.jpg"

3. **Second Iteration:** `2.jpg.ls()`
   - Prints: "File: 2.jpg"

4. **Third Iteration:** `3.jpg.ls()`
   - Prints: "File: 3.jpg"

5. **Fourth Iteration:** `Movies.ls()`
   - Prints: "Folder: Movies"
   - Iterates through children: [avengers.mp4, BigHero6.mp4]
   - Calls `avengers.mp4.ls()` → Prints: "File: avengers.mp4"
   - Calls `BigHero6.mp4.ls()` → Prints: "File: BigHero6.mp4"

### Expected Output:
```
Folder: Downloads
File: 1.jpg
File: 2.jpg
File: 3.jpg
Folder: Movies
File: avengers.mp4
File: BigHero6.mp4
```

## When to Use

✅ **Use Composite Pattern When:**
- You need to represent part-whole hierarchies of objects
- You want clients to treat individual objects and compositions uniformly
- You're working with tree-like structures (file systems, GUI components, organizational charts)
- You want to simplify client code by eliminating type-checking

❌ **Avoid When:**
- The structure is simple and doesn't need hierarchical organization
- Performance is critical and the recursive nature might cause issues
- You need fine-grained control over individual vs. composite behavior

## Advantages & Disadvantages

### ✅ Advantages:
- **Simplicity:** Client code treats all objects uniformly
- **Flexibility:** Easy to add new types of components
- **Maintainability:** No complex conditional logic based on object types
- **Recursive Operations:** Natural support for tree traversal operations

### ❌ Disadvantages:
- **Performance:** Recursive operations can be slower for deep hierarchies
- **Type Safety:** It can be harder to restrict component types
- **Complexity:** May overcomplicate simple structures

## Real-World Examples

### 1. **GUI Components**
```java
// Swing/AWT components
JPanel panel = new JPanel();     // Composite
JButton button = new JButton();  // Leaf
JLabel label = new JLabel();     // Leaf
panel.add(button);               // Adding leaf to composite
panel.add(label);                // Adding leaf to composite
```

### 2. **Organization Structure**
```java
Employee manager = new Manager("John");      // Composite
Employee developer = new Developer("Alice"); // Leaf
Employee tester = new Tester("Bob");         // Leaf
manager.addSubordinate(developer);
manager.addSubordinate(tester);
```

### 3. **Mathematical Expressions**
```java
Expression num1 = new Number(5);           // Leaf
Expression num2 = new Number(3);           // Leaf
Expression add = new Addition(num1, num2); // Composite
Expression result = add.evaluate();         // Returns 8
```

---

## 🎯 Key Takeaway

The Composite pattern is all about **"treating the one and the many the same way."** Whether you're dealing with a single file or an entire folder hierarchy, the client code remains simple and uniform.

**Remember:** The magic happens in the recursive call within the composite's operation method - this is what enables seamless traversal of the entire tree structure.

---

*This implementation demonstrates a classic file system example where the Composite pattern shines by allowing uniform treatment of files and folders while maintaining a clean, recursive structure.*
