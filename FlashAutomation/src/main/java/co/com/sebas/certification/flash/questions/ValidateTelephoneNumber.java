package co.com.sebas.certification.flash.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sebas.certification.flash.userinterfaces.UserPage.FIELD_NUMBER;

public class ValidateTelephoneNumber implements Question{
    @Override
    public Object answeredBy(Actor actor) {
        return FIELD_NUMBER.resolveFor(actor).getText().replace(" ","");
    }

    public static ValidateTelephoneNumber validateTelephoneNumber(){
        return new ValidateTelephoneNumber();
    }
}
