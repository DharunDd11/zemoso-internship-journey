// BEFORE - Violates DIP
class EmailServiceBad {

    void sendMessage() {
        System.out.println("Email Sent");
    }
}

class NotificationBad {

    private EmailServiceBad email = new EmailServiceBad();

    void notifyUser() {
        email.sendMessage();
    }
}

// MAIN CLASS AT END
public class DependencyInversionPrincipleBefore {

    public static void main(String[] args) {
        // BEFORE
        NotificationBad n1 = new NotificationBad();
        n1.notifyUser();

    }
}