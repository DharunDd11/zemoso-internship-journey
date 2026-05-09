public class ArrayWithObjects {

    String message;

    ArrayWithObjects(String message) {
        this.message = message;
        System.out.println("Constructor called with: " + message);
    }

    public static void main(String[] args) {

        System.out.println("--- Creating array of references ---");

        // Step 1: Create array, no objects yet
        ArrayWithObjects[] arr = new ArrayWithObjects[5];

        System.out.println("--- Array created, no objects yet ---");
        System.out.println();

        // Step 2: Now create actual objects
        System.out.println("--- Now creating actual objects ---");
        arr[0] = new ArrayWithObjects("Object 1");
        arr[1] = new ArrayWithObjects("Object 2");
        arr[2] = new ArrayWithObjects("Object 3");
        arr[3] = new ArrayWithObjects("Object 4");
        arr[4] = new ArrayWithObjects("Object 5");

        System.out.println();

        // Step 3: Print to confirm
        System.out.println("--- Printing array elements ---");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i].message);
        }
    }
}