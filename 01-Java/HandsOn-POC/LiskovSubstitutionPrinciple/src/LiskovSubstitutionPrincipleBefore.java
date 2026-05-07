// BEFORE - Violates LSP
class BirdBad {

    void fly() {
        System.out.println("Bird is flying");
    }
}

class SparrowBad extends BirdBad {

    void fly() {
        System.out.println("Sparrow is flying");
    }
}

class PenguinBad extends BirdBad {

    void fly() {
        System.out.println("Penguin cannot fly");
    }
}
// MAIN CLASS AT END
public class LiskovSubstitutionPrincipleBefore {

    public static void main(String[] args) {

        // BEFORE
        BirdBad b1 = new SparrowBad();
        b1.fly();

        BirdBad b2 = new PenguinBad();
        b2.fly();
    }
}