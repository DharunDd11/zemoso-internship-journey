// AFTER - Follows LSP
class Bird {

    void eat() {
        System.out.println("Bird is eating");
    }
}

class FlyingBird extends Bird {

    void fly() {
        System.out.println("Flying in sky");
    }
}

class Sparrow extends FlyingBird {

    void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {

    void eat() {
        System.out.println("Penguin is eating");
    }
}
// MAIN CLASS AT END
public class LiskovSubstitutionPrincipleAfter {
    public static void main(String[] args) {
        // AFTER

        Bird b1 = new Sparrow();
        b1.eat();

        Bird b2 = new Penguin();
        b2.eat();

        FlyingBird b3 = new Sparrow();
        b3.fly();
    }
}