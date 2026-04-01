package ex04_polymorphism;

public class Notification {
    protected String recipient;
    protected String message;
    protected String timestamp;

    public Notification(String recipient, String message, String timestamp) {
        this.recipient = recipient;
        this.message = message; 
        this.timestamp = timestamp;
    }

    public void send() {
        System.out.println("Message: " + message);
    }

    public String getType() {
        return "";
    }

    public String formatMessage() {
        return "";
    }
}
