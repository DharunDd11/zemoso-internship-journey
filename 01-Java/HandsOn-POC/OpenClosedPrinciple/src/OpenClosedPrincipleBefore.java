// BEFORE - Violates OCP
class PaymentBad {

    void pay(String type) {

        if (type.equals("Card")) {
            System.out.println("Paid using Card");
        }
        else if (type.equals("UPI")) {
            System.out.println("Paid using UPI");
        }
    }
}
class OpenClosedPrincipleBefore {
    public static void main (String [] args){


    PaymentBad payment = new PaymentBad();

        payment.pay("Card");
        payment.pay("UPI");
}
}