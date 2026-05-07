// AFTER - Follows DIP
interface MessageService {

    void sendMessage();
}
class EmailService implements MessageService {

    public void sendMessage() {
        System.out.println("Email Sent");
    }
}
class SmsService implements MessageService {

    public void sendMessage() {
        System.out.println("SMS Sent");
    }
}

class Notification {

    private MessageService service;

    Notification(MessageService service) {
        this.service = service;
    }

    void notifyUser() {
        service.sendMessage();
    }
}
// MAIN CLASS AT END
public class DependencyInversionPrincipleAfter {

    public static void main(String[] args) {
        // AFTER
        Notification n2 = new Notification(new EmailService());
        n2.notifyUser();

        Notification n3 = new Notification(new SmsService());
        n3.notifyUser();
    }
}