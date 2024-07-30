package decoratorpattern;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackSMSNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        slackSMSNotifier.send("Test");
    }
}
