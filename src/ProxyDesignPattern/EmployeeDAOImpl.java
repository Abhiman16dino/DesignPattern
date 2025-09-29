package ProxyDesignPattern;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void save() {
        System.out.println("Employee saved");
    }

    @Override
    public void delete() {
        System.out.println("Employee deleted");
    }

    @Override
    public void create() {
        System.out.println("Employee created");
    }
}
