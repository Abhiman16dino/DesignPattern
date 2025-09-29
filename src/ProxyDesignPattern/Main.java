package ProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Proxy Design Pattern Example");
        EmployeeDAO employeeDAO = new EmployeeProxyDAO();
        employeeDAO.create();
        employeeDAO.save();
        employeeDAO.delete();
    }
}

/*

Proxy Design Pattern Example
Logging before creating employee
Employee created
Logging after creating employee
Logging before saving employee
Employee saved
Logging after saving employee
Logging before deleting employee
Employee deleted
Logging after deleting employee

*/