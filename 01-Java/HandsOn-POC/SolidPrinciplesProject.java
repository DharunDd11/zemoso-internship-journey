// Base Class (LSP)
// Child classes can replace Employee safely

class Employee {

    protected String name;

    Employee(String name) {
        this.name = name;
    }

    void showRole() {
        System.out.println("Employee");
    }
}
// LSP - Developer is-a Employee
// ISP - Implements only workable behavior
class Developer extends Employee implements Workable {

    Developer(String name) {
        super(name);
    }

    public void work() {
        System.out.println(name + " writes code");
    }

    void showRole() {
        System.out.println("Developer");
    }
}
// LSP - Manager is-a Employee
// ISP - Implements workable + manageable
class Manager extends Employee implements EmployeeWorkable, EmployeeManageable {

    Manager(String name) {
        super(name);
    }

    public void work() {
        System.out.println(name + " manages team");
    }

    public void manage() {
        System.out.println(name + " approves tasks");
    }

    void showRole() {
        System.out.println("Manager");
    }
}

// ISP - Small focused interfaces
// Classes implement only needed methods
interface EmployeeWorkable {
    void work();
}

interface EmployeeManageable {
    void manage();
}

// SRP - Only handles data saving
// One responsibility
class EmployeeRepository {

    void save(Employee e) {
        System.out.println("Saved " + e.name);
    }
}
// SRP - Only handles reports
// One responsibility
class ReportService {

    void generate(Employee e) {
        System.out.println("Report generated for " + e.name);
    }
}

// OCP - Open for extension - New notification types can be added
// DIP - High-level classes depend on - abstraction, not concrete classes

interface NotificationService {
    void send(String msg);
}

// OCP - New implementation
class EmailNotification implements NotificationService {

    public void send(String msg) {
        System.out.println("Email: " + msg);
    }
}

// OCP - Another implementation

class SmsNotification implements NotificationService {

    public void send(String msg) {
        System.out.println("SMS: " + msg);
    }
}


// DIP - Depends on interface - not EmailNotification directly

class EmployeeService {

    private NotificationService service;

    EmployeeService(NotificationService service) {
        this.service = service;
    }

    void notifyEmployee(String name) {
        service.send("Hello " + name);
    }
}
// Main Class
public class SolidPrinciplesProject {

    public static void main(String[] args) {

        // LSP - Child objects used as Employee types
        Developer d = new Developer("Arjun");
        Manager m = new Manager("Rahul");

        d.showRole();
        d.work();

        m.showRole();
        m.work();
        m.manage();

        EmployeeRepository repo = new EmployeeRepository();
        repo.save(d);

        ReportService report = new ReportService();
        report.generate(m);

        EmployeeService e1 = new EmployeeService(new EmailNotification());

        e1.notifyEmployee("Arjun");

        EmployeeService e2 = new EmployeeService(new SmsNotification());

        e2.notifyEmployee("Rahul");
    }
}