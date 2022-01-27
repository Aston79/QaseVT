import models.Project;
import models.ProjectFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

        String projectName = project.getProjectName();
        $(By.xpath("//tr[td/div/a[@class=\"defect-title\"][text()=\"" + projectName + "\"]]/td/div/a[i]")).click();
        $(By.xpath("//div[@class='dropdown-menu dropdown-menu-end show']//div[1]")).shouldBe(visible, Duration.ofSeconds(5));
        $(By.xpath("//i[@class=\"fa fa-ellipsis-h\"]")).click();
        $(By.xpath("//a[contains(@href,'delete')]")).click();
        $(By.xpath("//button[normalize-space()=\"Delete project\"][1]")).click();

    }

    @Test
    public void projectSearch() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);
        $(By.xpath("//input[@name='title']")).setValue("FakeProject").pressEnter();
//        $(By.name("FakeProject")).shouldNotBe(exist);
    }
}
