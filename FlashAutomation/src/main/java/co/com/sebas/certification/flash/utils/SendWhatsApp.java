package co.com.sebas.certification.flash.utils;

import co.com.sebas.certification.flash.models.DataToSendWhatsApp;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import java.util.List;

public class SendWhatsApp {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC105bdb314e92a3439625a6a94f67f251";
    public static final String AUTH_TOKEN = "3316aada926efcdd8a1e27d263d1bffa";

    private String message;

    public SendWhatsApp(String message) {
        this.message = message;
    }

    public static void send(String messageBL) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+573215339791"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        messageBL)
                .create();

        System.out.println(message.getSid());
    }
}
