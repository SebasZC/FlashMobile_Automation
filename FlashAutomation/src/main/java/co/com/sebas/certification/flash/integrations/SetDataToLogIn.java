package co.com.sebas.certification.flash.integrations;

import co.com.sebas.certification.flash.utils.Encrypter;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static co.com.sebas.certification.flash.userinterfaces.HomePage.*;

public class SetDataToLogIn implements Task {

    private String user;
    private String password;
    final String passwordEncryption = "secret!";

    public SetDataToLogIn(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Clase: SetDataToLogIn\nuser: "+ user+"\nPassword: "+password);
        try {
            actor.attemptsTo(
                    Click.on(LOG_IN_BUTTON),
                    Click.on(MY_ACCOUNT_BUTTON),
                    Enter.theValue(Encrypter.decrypt(user,passwordEncryption)).into(USER_FIELD),
                    Enter.theValue(Encrypter.decrypt(password,passwordEncryption)).into(PASSWORD_FIELD),
                    Click.on(SUBMIT_BUTTON)

            );
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public static SetDataToLogIn setData(String user, String password){
        return Tasks.instrumented(SetDataToLogIn.class, user,password);
    }
}
