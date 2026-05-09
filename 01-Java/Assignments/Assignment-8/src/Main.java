/*
Create three new types of exceptions. Write a class with a method that throws all three.
In main( ), call the method but only use a single catch clause that will catch all three types of exceptions.
Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.

 */

class FirstException extends Exception {
    FirstException(String msg) {
        super(msg);
    }
}

class SecondException extends Exception {
    SecondException(String msg) {
        super(msg);
    }
}

class ThirdException extends Exception {
    ThirdException(String msg) {
        super(msg);
    }
}

class Test {

    void check(int n) throws FirstException, SecondException, ThirdException {

        if (n == 1) {
            throw new FirstException("First Exception Occurred");
        }
        else if (n == 2) {
            throw new SecondException("Second Exception Occurred");
        }
        else if (n == 3) {
            throw new ThirdException("Third Exception Occurred");
        }
        else if (n == 4) {
            String s = null;
            System.out.println(s.length());   // NullPointerException
        }
        else {
            System.out.println("No Exception");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Test t = new Test();

        try {
            t.check(4);   // Change value: 1,2,3,4
        }
        catch (Exception e) {   // Single catch handles all exceptions
            System.out.println("Caught: " + e);
        }
        finally {
            System.out.println("Finally block always executes");
        }
    }
}