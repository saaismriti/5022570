package adapterpattern;

public class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of ₹" + amount + " made through PayPal.");
    }
}