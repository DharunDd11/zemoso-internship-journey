// AFTER - Each class has one job
// Follows Principle
class Report {

    void createReport() {
        System.out.println("Report Created");
    }
}

class ReportPrinter {

    void printReport() {
        System.out.println("Report Printed");
    }
}

class ReportSaver {

    void saveReport() {
        System.out.println("Report Saved");
    }
}
public class SingleResponsibilityPrincipleAfter {

    public static void main(String[] args) {


        // AFTER (Follows Principle)

        Report report = new Report();
        report.createReport();

        ReportPrinter printer = new ReportPrinter();
        printer.printReport();

        ReportSaver saver = new ReportSaver();
        saver.saveReport();
    }
}