package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage{

    public static final SelenideElement EMAIL_INPUT = $("#inputEmail");
    public static final SelenideElement PASSWORD_INPUT = $("#inputPassword");
    public static final SelenideElement LOGIN_BUTTON = $("#btnLogin");

    public void openLoginPage() {
        open("/login");
    }

    public boolean isPageOpened() {
        return isExist(LOGIN_BUTTON);
    }

    public ProjectPage login(String user, String password) {
        $(EMAIL_INPUT).sendKeys(user);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return new ProjectPage();
    }
}
