package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import models.Project;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPage extends BasePage{

    public static final SelenideElement USER_MENU_IMAGE = $("#user-menu");
    public static final SelenideElement CREATE_NEW_PROJECT_BUTTON = $("#createButton");
    public static final SelenideElement SEARCH_INPUT = $("[name='title']");

    String locatorProjectName = "//*[text()='%s']";

    public boolean isPageOpened() {
        return isExist(USER_MENU_IMAGE);
    }

    public void openProjectPage() {
        open("/projects");
    }

    public void checkProject(Project project) {
        SEARCH_INPUT.setValue(project.getProjectName());
        $(byXpath(String.format(locatorProjectName, project.getProjectName()))).shouldBe(Condition.visible);
    }

    public void clickButtonCreateNewProject() {
        $(CREATE_NEW_PROJECT_BUTTON).click();
    }
}
