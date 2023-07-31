package co.com.sebas.certification.flash.userinterfaces.WhatsApp;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target CHAT_CUSTOMER = Target.the("field to search customer")
            .located(By.xpath("//*[@id=\"action-button\"]/span"));
    public static final Target CUSTOMER_SEARCHED = Target.the("name of the customer")
            .located(By.xpath("//*[@class='_3OvU8']"));
    public static final Target FIELD_TEXT_MESSAGE = Target.the("to send to client the message")
            .located(By.xpath("(//*[@class='selectable-text copyable-text'])[2]"));
    public static final Target SEND_BUTTON = Target.the("send button")
            .located(By.xpath("//*[@class='tvf2evcx oq44ahr5 lb5m6g5c svlsagor p2rjqpw5 epia9gcq']"));
}
