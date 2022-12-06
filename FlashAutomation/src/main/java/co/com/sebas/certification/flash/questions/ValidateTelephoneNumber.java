package co.com.sebas.certification.flash.questions;

import co.com.sebas.certification.flash.integrations.SendWhatsappMessage;
import co.com.sebas.certification.flash.integrations.SwicthPage;
import co.com.sebas.certification.flash.utils.SendWhatsApp;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.sebas.certification.flash.userinterfaces.UserPage.FIELD_NUMBER;
import static co.com.sebas.certification.flash.utils.Constants.FLASH_MOBILE_URL;
import static co.com.sebas.certification.flash.utils.Constants.WHATSAPP_MOBILE_URL;

public class ValidateTelephoneNumber implements Question{
    private String telephoneNumber;

    public ValidateTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public Object answeredBy(Actor actor) {
        return FIELD_NUMBER.resolveFor(actor).getText().replace(" ","");
    }

    public static ValidateTelephoneNumber validateTelephoneNumber(String telephoneNumber){
        return new ValidateTelephoneNumber(telephoneNumber);
    }
}
