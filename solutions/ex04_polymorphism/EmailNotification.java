package ex04_polymorphism;

public class EmailNotification extends Notification {

    private String subject;
    private String senderEmail;


    public EmailNotification(String recipient, String message, String timestamp) {
        super(recipient, message, timestamp);
    }

    @Override
    public void send() {
        System.out.println("Sending " + message);
    }

    @Override
    public String getType() {
        return "email";
    }

    @Override
    public String formatMessage() {
        return "@";
    }
}
