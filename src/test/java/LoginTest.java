import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{

    @Test
    public void login() {
        open("/login");
        $("#inputEmail").sendKeys("aston79.vt@gmail.com");
        $(By.xpath("//*[@id='inputPassword']")).setValue("knz3x!SNpv88vBK").submit();
        $(By.id("createButton")).shouldBe(visible, Duration.ofSeconds(60));
    }
    @Test
    public void login2() {
        open("/login");
        $("#inputEmail").sendKeys("aston79.vt@gmail.com");
        $(By.xpath("//*[@id='inputPassword']")).setValue("knz3x!SNpv88vBK").submit();
        $(By.id("createButton")).shouldBe(visible);
    }
}



