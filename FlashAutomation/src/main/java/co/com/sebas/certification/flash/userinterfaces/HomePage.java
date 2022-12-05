package co.com.sebas.certification.flash.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class HomePage {
    public static final Target LOG_IN_BUTTON = Target.the("log in button")
            .located(By.xpath("//*[@class='btn btn-default dropdown-toggle sign-in js-sign-in']"));

    public static final Target MY_ACCOUNT_BUTTON = Target.the("my account button")
            .located(By.xpath("(//*[@class='js-self-care'])[1]"));

    public static final Target USER_FIELD = Target.the("text input user")
            .located(By.xpath("(//*[@id='login'])[1]"));

    public static final Target PASSWORD_FIELD = Target.the("text input password")
            .located(By.xpath("(//*[@id='password'])[1]"));

    public static final Target SUBMIT_BUTTON = Target.the("submit button")
            .located(By.xpath("(//*[@class='btn btn-primary btn-block'])[1]"));
}
