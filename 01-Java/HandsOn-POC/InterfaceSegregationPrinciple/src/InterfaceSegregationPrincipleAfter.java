// AFTER - Follows ISP
interface Workable {

    void work();
}

interface Eatable {

    void eat();
}

class Robot implements Workable {

    public void work() {
        System.out.println("Robot is working");
    }
}

class Human implements Workable, Eatable {

    public void work() {
        System.out.println("Human is working");
    }

    public void eat() {
        System.out.println("Human is eating");
    }
}



public class InterfaceSegregationPrincipleAfter {

    public static void main(String[] args) {
        // AFTER

        Robot r = new Robot();
        r.work();

        Human h = new Human();
        h.work();
        h.eat();
    }
}