package BuilderDesignPattern;

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
