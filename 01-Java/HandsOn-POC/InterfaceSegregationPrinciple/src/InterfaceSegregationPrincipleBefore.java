// BEFORE - Violates ISP
interface WorkerBad {

    void work();
    void eat();
}

class RobotBad implements WorkerBad {

    public void work() {
        System.out.println("Robot is working");
    }

    public void eat() {
        System.out.println("Robot cannot eat");
    }
}

class HumanBad implements WorkerBad {

    public void work() {
        System.out.println("Human is working");
    }

    public void eat() {
        System.out.println("Human is eating");
    }
}

public class InterfaceSegregationPrincipleBefore {

    public static void main(String[] args) {

        // BEFORE
        RobotBad r = new RobotBad();
        r.work();
        r.eat();
        HumanBad h = new HumanBad();
        h.work();
        h.eat();

    }
}