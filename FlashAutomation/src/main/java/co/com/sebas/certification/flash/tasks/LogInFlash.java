package co.com.sebas.certification.flash.tasks;

import co.com.sebas.certification.flash.integrations.SetDataToLogIn;
import co.com.sebas.certification.flash.utils.Encrypter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class LogInFlash implements Task {

    private String user;
    private String password;

    public LogInFlash(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SetDataToLogIn.setData(user, password));
    }

    public static LogInFlash logIn(String user, String password) {
        return Tasks.instrumented(LogInFlash.class, user, password);
    }

}
