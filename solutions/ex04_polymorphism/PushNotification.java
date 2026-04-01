package ex04_polymorphism;

public class PushNotification extends Notification {
    private String appName;
    private String deviceId;

    public PushNotification(String recipient, String message, String timestamp, String appName, String deviceId) {
        super(recipient, message, timestamp);
        this.appName = appName;
        this.deviceId = deviceId;
    }

    @Override
    public void send() {
        System.out.println("Sending " + message);
    }

    @Override
    public String getType() {
        return "Push";
    }

    @Override
    public String formatMessage() {
        return "Push: " + message;
    }
}
