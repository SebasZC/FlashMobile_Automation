package co.com.sebas.certification.flash.integrations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sebas.certification.flash.userinterfaces.WhatsApp.HomePage.*;
import static co.com.sebas.certification.flash.utils.Constants.FLASH_MOBILE_URL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SendWhatsappMessage implements Task {

    private String name;

    public SendWhatsappMessage(String name) {
        this.name = name;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitUntil.the(SEND_BUTTON, isClickable()).forNoMoreThan(9900).seconds();
        actor.attemptsTo(Click.on(SEND_BUTTON));
    }
    public static SendWhatsappMessage sendWhatsappMessage(String name){
        return new SendWhatsappMessage(name);
    }
}
