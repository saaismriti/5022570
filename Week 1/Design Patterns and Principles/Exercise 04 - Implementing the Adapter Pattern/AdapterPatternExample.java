package adapterpattern;

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor phonePeProcessor = new PhonePeAdapter(new PhonePeGateway());

        payPalProcessor.processPayment(30.00);
        phonePeProcessor.processPayment(50.00);
    }
}
