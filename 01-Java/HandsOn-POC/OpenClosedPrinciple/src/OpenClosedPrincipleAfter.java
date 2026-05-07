// AFTER - Follows OCP
interface PaymentMethod {

    void pay();
}

class CardPayment implements PaymentMethod {

    public void pay() {
        System.out.println("Paid using Card");
    }
}

class UpiPayment implements PaymentMethod {

    public void pay() {
        System.out.println("Paid using UPI");
    }
}
class PaymentService {

    void pay(PaymentMethod method) {
        method.pay();
    }
}
public class OpenClosedPrincipleAfter {

    public static void main(String[] args) {
        // AFTER
        PaymentService service = new PaymentService();

        service.pay(new CardPayment());
        service.pay(new UpiPayment());
    }
}