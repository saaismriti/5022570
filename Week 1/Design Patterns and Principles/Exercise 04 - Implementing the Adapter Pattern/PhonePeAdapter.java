package adapterpattern;

public class PhonePeAdapter implements PaymentProcessor {
    private PhonePeGateway phonePeGateway;

    public PhonePeAdapter(PhonePeGateway phonePeGateway) {
        this.phonePeGateway = phonePeGateway;
    }

    @Override
    public void processPayment(double amount) {
        phonePeGateway.pay(amount);
    }
}
