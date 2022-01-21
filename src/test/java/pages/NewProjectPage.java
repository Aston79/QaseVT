package pages;

import com.codeborne.selenide.SelenideElement;
import models.Project;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage extends BasePage{

    public static final SelenideElement NEW_PROJECT_TEXT = $(byText("New Project"));
    public static final SelenideElement PROJECT_NAME_INPUT = $("#inputTitle");
    public static final SelenideElement PROJECT_CODE_INPUT = $("#inputCode");
    public static final SelenideElement DESCRIPTION_INPUT = $("#inputDescription");
    public static final SelenideElement CHECK_INPUT = $("#public-access-type");

    public boolean isPageOpened() {
        return isExist(NEW_PROJECT_TEXT);
    }

    public void createProject(Project project) {
        PROJECT_NAME_INPUT.sendKeys(project.getProjectName());
        PROJECT_CODE_INPUT.sendKeys(project.getProjectCode());
        DESCRIPTION_INPUT.sendKeys(project.getDescription());
        CHECK_INPUT.click();
        PROJECT_NAME_INPUT.submit();
    }
}
