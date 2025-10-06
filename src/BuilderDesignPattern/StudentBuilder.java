package BuilderDesignPattern;

public class StudentBuilder {
    String name;
    int age;
    int roll;
    String father;
    String mother;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }
    public StudentBuilder setRoll(int roll) {
        this.roll = roll;
        return this;
    }
    public StudentBuilder setFather(String father) {
        this.father = father;
        return this;
    }
    public StudentBuilder setMother(String mother) {
        this.mother = mother;
        return this;
    }

    public Student build() {
        return new Student(this);
    }
}
