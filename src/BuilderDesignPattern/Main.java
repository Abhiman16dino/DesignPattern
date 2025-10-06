package BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        Student student = studentBuilder.setName("John")
                .setAge(20)
                .setRoll(101)
                .setFather("Doe")
                .setMother("Jane")
                .build();
        System.out.println(student);
        // Student [name=John, age=20, roll=101, father=Doe, mother=Jane]

        Student student1 = new StudentDirector().createStudent("Alice", 22, 102, "Bob", "Eve");
        System.out.println(student1);
//        Student [name=Alice, age=22, roll=102, father=Bob, mother=Eve]
    }
}
