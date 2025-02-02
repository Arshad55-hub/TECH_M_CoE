class Person {
    private String fullName;
    private int age;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{fullName='" + fullName + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && fullName.equals(person.fullName);
    }

    @Override
    public int hashCode() {
        return fullName.hashCode() + age;
    }
}

class AnotherPerson {
    private String fullName;
    private int age;

    public AnotherPerson(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }
}

public class ObjectDemo {
    public static void main(String[] args) {
        Person individual1 = new Person("Bob", 30);
        Person individual2 = new Person("Bob", 30);
        AnotherPerson anotherIndividual = new AnotherPerson("Bob", 30);

        System.out.println(individual1.toString()); 
        System.out.println(anotherIndividual.toString()); 

        System.out.println(individual1.equals(individual2)); 
        System.out.println(individual1.equals(anotherIndividual)); 
    }
}
