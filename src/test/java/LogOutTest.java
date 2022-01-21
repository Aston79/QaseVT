import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class LogOutTest extends BaseTest{
    @Test
    public void logOut(){
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);
        $(By.xpath("//img[@id='user-menu']")).click();
        $(By.xpath("//a[normalize-space()='Sign out']")).click();
        assertTrue(loginPage.isPageOpened(), "LogIn page doesn't open");

    }
}
