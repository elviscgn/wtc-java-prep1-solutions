package ex04_polymorphism;

public class SMSNotification extends Notification {

    private String phoneNumber;

    public SMSNotification(String recipient, String message, String timestamp, String number) {
        super(recipient, message, timestamp);
        this.phoneNumber = number;
    }

    @Override
    public void send() {
        System.out.println("Sending " + message + " To: " + phoneNumber);
    }

    @Override
    public String getType() {
        return "sms";
    }

    @Override
    public String formatMessage() {
        return message.substring(0, 159);
    }


}
