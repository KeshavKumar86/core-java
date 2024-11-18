package solid.ocp;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendOTP(String medium) {
        //write email related logic
        //use javaMailSenderAPI
    }

    @Override
    public void sendTransactionReport(String medium) {
    //write email related logic
    }
}
