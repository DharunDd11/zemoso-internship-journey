// BEFORE - One class doing many jobs
// Violates Principle
class ReportBad {

    void createReport() {
        System.out.println("Report Created");
    }

    void printReport() {
        System.out.println("Report Printed");
    }

    void saveReport() {
        System.out.println("Report Saved");
    }
}

public class SingleResponsibilityPrincipleBefore {

    public static void main(String[] args) {


        // AFTER (Follows Principle)

        ReportBad report = new ReportBad();
         report.createReport();
         report.printReport();
         report.saveReport();

    }
}