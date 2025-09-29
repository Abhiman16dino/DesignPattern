package ProxyDesignPattern;

public class EmployeeProxyDAO implements EmployeeDAO{
    EmployeeDAOImpl dao;
    public EmployeeProxyDAO() {
        dao = new EmployeeDAOImpl();
    }

    @Override
    public void save() {
        System.out.println("Logging before saving employee");
        dao.save();
        System.out.println("Logging after saving employee");
    }

    @Override
    public void delete() {
        System.out.println("Logging before deleting employee");
        dao.delete();
        System.out.println("Logging after deleting employee");
    }

    @Override
    public void create() {
        System.out.println("Logging before creating employee");
        dao.create();
        System.out.println("Logging after creating employee");
    }
}
