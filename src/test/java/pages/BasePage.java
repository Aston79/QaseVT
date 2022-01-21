package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;

public abstract class BasePage {

    public abstract boolean isPageOpened();

    public boolean isExist(SelenideElement element) {
        try {
            element.shouldBe(Condition.visible);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
