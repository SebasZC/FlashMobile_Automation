package co.com.sebas.certification.flash.integrations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sebas.certification.flash.userinterfaces.WhatsApp.HomePage.*;
import static co.com.sebas.certification.flash.utils.Constants.FLASH_MOBILE_URL;

public class SendWhatsappMessage implements Task {

    private String name;

    public SendWhatsappMessage(String name) {
        this.name = name;
    }

    WebDriver driver = new ChromeDriver();
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(99000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //WebElement m=driver.findElement(By.xpath("//*[@class='selectable-text copyable-text'])[2]"));
        //m.sendKeys(Keys.ENTER);
        System.out.println("Tiempo de espera agotado");
        actor.attemptsTo(Click.on(SEND_BUTTON));
    }
    public static SendWhatsappMessage sendWhatsappMessage(String name){
        return new SendWhatsappMessage(name);
    }
}
