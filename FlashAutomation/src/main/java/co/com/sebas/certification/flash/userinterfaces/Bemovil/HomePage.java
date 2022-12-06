package co.com.sebas.certification.flash.userinterfaces.Bemovil;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target USER_NAME = Target.the("input user name")
            .located(By.xpath("//*[@id=\"id_0-username\"]"));
    public static final Target USER_PASSWORD = Target.the("input the password")
            .located(By.xpath("//*[@id=\"id_1-password\"]"));
    public static final Target FLASH_RECHARGE = Target.the("recharge to flash")
            .located(By.xpath("//*[@id=\"Flash\"]"));
    public static final Target TELEPHONE_NUMBER_FLASH = Target.the("telephone number to recharge")
            .located(By.xpath("//*[@id=\"id_serviceNumber\"]"));
    public static final Target AMOUNT = Target.the("amount to recharge")
            .located(By.xpath("//*[@id=\"id_amount\"]"));
    public static final Target MULTI_PRODUCT = Target.the("multi product to recharge")
            .located(By.xpath("//*[@id=\"nav\"]/li[3]/a"));
    public static final Target MULTI_PRODUCT_RECHARGE = Target.the("multi product to recharge")
            .located(By.xpath("//*[@id=\"nav\"]/li[3]/ul/li[1]/a"));

    public static final Target RECHARGE_BUTTON = Target.the("button to recharge")
            .located(By.xpath("//*[@id=\"topupForm\"]/input[3]"));
    public static final Target NEXT = Target.the("next step")
            .located(By.xpath("//*[@id=\"logindiv\"]/form/button"));

    public static final Target ACCEPT_RECHARGE = Target.the("accept to do a recharge")
            .located(By.xpath("//*[@id=\"apprise-btn-undefined\"]"));
}
