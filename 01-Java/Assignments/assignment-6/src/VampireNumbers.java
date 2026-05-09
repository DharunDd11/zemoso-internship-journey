import java.util.Arrays;

public class VampireNumbers {

    static boolean hasEvenDigits(int n) {
        String s = String.valueOf(n);
        return s.length() % 2 == 0;
    }

    static char[] getSortedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        return digits;
    }

    static boolean bothHaveTrailingZero(int x, int y) {
        return (x % 10 == 0) && (y % 10 == 0);
    }

    static boolean isVampire(int n) {
        if (!hasEvenDigits(n)) return false;

        String s = String.valueOf(n);
        int totalDigits = s.length();
        int fangDigits = totalDigits / 2;

        int fangStart = (int) Math.pow(10, fangDigits - 1);
        int fangEnd = (int) Math.pow(10, fangDigits) - 1;

        for (int x = fangStart; x <= fangEnd; x++) {
            if (n % x != 0) continue;

            int y = n / x;

            if (y < fangStart || y > fangEnd) continue;
            if (x > y) continue;
            if (bothHaveTrailingZero(x, y)) continue;

            char[] originalDigits = getSortedDigits(n);

            String combined = String.valueOf(x) + String.valueOf(y);
            char[] combinedDigits = combined.toCharArray();
            Arrays.sort(combinedDigits);

            if (Arrays.equals(originalDigits, combinedDigits)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        int num = 10;

        System.out.println("First 100 Vampire Numbers:");
        System.out.println("==========================");

        while (count < 100) {
            if (isVampire(num)) {
                count++;
                System.out.println(count + ". " + num);
            }
            num++;
        }
    }
}