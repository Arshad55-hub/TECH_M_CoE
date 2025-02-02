abstract class Creature {
    abstract void produceSound();
}

class Canine extends Creature {
    @Override
    void produceSound() {
        System.out.println("The canine is barking.");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Creature animal = new Canine();
        animal.produceSound();
    }
}
