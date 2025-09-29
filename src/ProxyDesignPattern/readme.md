# Proxy Design Pattern

This example demonstrates the Proxy Design Pattern in Java.

## Overview
The Proxy Design Pattern provides a surrogate or placeholder for another object to control access to it. It is useful for implementing access control, lazy initialization, logging, or caching.

## Structure
- **EmployeeDAO**: Interface defining employee data operations.
- **EmployeeDAOImpl**: Real implementation of EmployeeDAO.
- **EmployeeProxyDAO**: Proxy class that controls access to EmployeeDAOImpl (e.g., adds security checks).
- **Main**: Demonstrates usage of the proxy to access employee data.

## How it works
The client interacts with the proxy (`EmployeeProxyDAO`) instead of the real object (`EmployeeDAOImpl`). The proxy can add extra logic before or after delegating calls to the real object.

## Usage
Run `Main.java` to see how the proxy controls access to employee data.

