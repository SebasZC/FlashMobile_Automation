package co.com.sebas.certification.flash.tasks;

import co.com.sebas.certification.flash.integrations.SetDataToLogIn;
import co.com.sebas.certification.flash.utils.CSVReader;
import co.com.sebas.certification.flash.utils.Encrypter;
import net.serenitybdd.core.Serenity;
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

    private int register;

    public LogInFlash(int register) {
        this.register = register;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("leyendo.....");
        CSVReader.readData(register);
        System.out.println("User: " + Serenity.sessionVariableCalled("user"));
        System.out.println("User: " + Serenity.sessionVariableCalled("password"));
        try {
            actor.attemptsTo(SetDataToLogIn.setData(Encrypter.decrypt("FL-2020@*confidenTi4l*",Serenity.sessionVariableCalled("user")),Encrypter.decrypt("FL-2020@*confidenTi4l*",Serenity.sessionVariableCalled("password"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static LogInFlash logIn(int register) {
        return Tasks.instrumented(LogInFlash.class, register);
    }
}
