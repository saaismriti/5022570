package strategypattern;

public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9123-4567");
        PaymentStrategy paypal = new PayPalPayment("user@mail.com");

        PaymentContext context = new PaymentContext(creditCard);
        context.executePayment(800.00);

        context = new PaymentContext(paypal);
        context.executePayment(650.00);
    }
}
