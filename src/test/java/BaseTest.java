import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectPage;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    String email, password;
    LoginPage loginPage;
    ProjectPage projectPage;
    NewProjectPage newProjectPage;

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url")); //"https://app.qase.io";
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));

        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;

        loginPage = new LoginPage();
        newProjectPage = new NewProjectPage();
        projectPage = new ProjectPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }
}
