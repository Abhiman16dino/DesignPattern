package BuilderDesignPattern;

public class Student {
    String name;
    int age;
    int roll; // Only required field
    String father;
    String mother;

    public Student(StudentBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.father = builder.father;
        this.roll = builder.roll;
        this.mother = builder.mother;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", roll=" + roll + ", father=" + father + ", mother=" + mother + "]";
    }
}
