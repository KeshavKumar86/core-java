package solid.srp;

public class NotificationService {
    public void sendOTP(String medium){
        if(medium.equals("email")){
            //write email related logic
            //use javaMailSenderAPI
        }
        if(medium.equals("mobile")){
            //write logic using twillio api
        }
    }
}
