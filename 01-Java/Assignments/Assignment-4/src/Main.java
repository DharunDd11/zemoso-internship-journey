import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Year;
import java.util.Scanner;

public class Main {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            LocalDate signupDate = LocalDate.parse(parts[0], formatter);
            LocalDate today = LocalDate.parse(parts[1], formatter);

            String result = getKYCRange(signupDate, today);
            System.out.println(result);
        }

        sc.close();
    }

    // ✅ NEW: Handles leap year edge case when getting anniversary for a specific year
    static LocalDate getAnniversaryForYear(LocalDate signupDate, int year) {
        // If signup was on Feb 29 and target year is not a leap year
        // use Feb 28 instead
        if (signupDate.getMonthValue() == 2
                && signupDate.getDayOfMonth() == 29
                && !Year.isLeap(year)) {
            return LocalDate.of(year, 2, 28);
        }
        return signupDate.withYear(year);
    }

    static String getKYCRange(LocalDate signupDate, LocalDate today) {

        // Step 1: Get anniversary for current year using leap-year-safe method
        LocalDate anniversary = getAnniversaryForYear(signupDate, today.getYear());

        // Step 2: If anniversary is more than 30 days in future, use last year's
        if (anniversary.isAfter(today.plusDays(30))) {
            anniversary = getAnniversaryForYear(signupDate, today.getYear() - 1);
        }

        // Step 3: Make sure we don't use the signup year itself
        if (anniversary.getYear() == signupDate.getYear()) {
            anniversary = getAnniversaryForYear(signupDate, signupDate.getYear() + 1);
        }

        // Step 4: Calculate ±30 day window
        LocalDate windowStart = anniversary.minusDays(30);
        LocalDate windowEnd = anniversary.plusDays(30);

        // Step 5: If today is before window starts → No range
        if (today.isBefore(windowStart)) {
            return "No range";
        }

        // Step 6: Cap window end at today if needed
        if (windowEnd.isAfter(today)) {
            windowEnd = today;
        }

        return windowStart.format(formatter) + " " + windowEnd.format(formatter);
    }
}

/*
Gruber Healthcare needs customers to fill
a KYC form every year.

Rule: Form can only be filled within
      ±30 days of signup anniversary

Input:  signup date + today's date
Output: valid date range to write on form

Special cases handled:
→ Today before window  = No range
→ Today inside window  = cap end at today
→ Today past window    = full window (backdating)
→ Leap year signup     = fallback to Feb 28
 */