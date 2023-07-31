package co.com.sebas.certification.flash.integrations;

import co.com.sebas.certification.flash.utils.Encrypter;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static co.com.sebas.certification.flash.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SetDataToLogIn implements Task {

    private String user;
    private String password;
    final String passwordEncryption = "FL-2020@*confidenTi4l*"; //poner como variable de entorno

    public SetDataToLogIn(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Clase: SetDataToLogIn\nuser: "+ user+"\nPassword: "+password);
        try {
            actor.attemptsTo(
                    WaitUntil.the(LOG_IN_BUTTON, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(LOG_IN_BUTTON),
                    Click.on(MY_ACCOUNT_BUTTON),
                    Enter.theValue(user).into(USER_FIELD),
                    Enter.theValue(password).into(PASSWORD_FIELD),
                    Click.on(SUBMIT_BUTTON)

            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SetDataToLogIn setData(String user, String password){
        return Tasks.instrumented(SetDataToLogIn.class, user,password);
    }
}
