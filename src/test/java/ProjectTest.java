import models.Project;
import models.ProjectFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreatedAndDeleted() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);
        $(By.xpath("//a[@id='createButton']")).click();
        Project project = ProjectFactory.get();
        newProjectPage.createProject(project);
        projectPage.openProjectPage();
        projectPage.checkProject(project);
        $(By.xpath("//*[@id=\"react-app\"]/div/div/div/div/table/tbody/tr[3]/td[1]/button/i")).shouldNotBe(visible);
        $(By.xpath("//*[@id=\"react-app\"]/div/div/div/div/table/tbody/tr[3]/td[8]/div/a/i")).click();
        $(By.xpath("//*[@id=\"react-app\"]/div/div/div/div/table/tbody/tr[3]/td[8]/div/div/div[2]/a")).click();
        $(By.xpath("//button[normalize-space()='Delete project']")).click();
        $(By.xpath("//*[@id=\"react-app\"]/div/div/div/div/h1")).shouldBe(visible);
    }

    @Test
    public void projectSearch() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);
        $(By.xpath("//input[@name='title']")).setValue("fakeProject").pressEnter();
    }
}
