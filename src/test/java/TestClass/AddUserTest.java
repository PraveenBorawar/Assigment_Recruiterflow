package TestClass;

import OrangeHrmPages.DashboardPage;
import OrangeHrmPages.LoginPage;
import OrangeHrmPages.RecruiterPage;
import Utils.UtilityMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest extends BaseTest {

    @Test
    public void addRecruiter() throws IOException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.userName.sendKeys(prop.getProperty("userName"));
        loginPage.password.sendKeys(prop.getProperty("passWord"));
        loginPage.submitButton.click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.dashboardTitle.getText(), "Dashboard");
        dashboardPage.clickRecruitment.click();

        RecruiterPage recruiterPage = new RecruiterPage(driver);
        recruiterPage.addButton.click();
        recruiterPage.firstName.sendKeys("Praveen");
        recruiterPage.middleName.sendKeys("New");
        recruiterPage.lastName.sendKeys("Test");
        recruiterPage.selectVacancyPosition("Senior QA Lead");
        recruiterPage.email.sendKeys("testabc@gmail.com");
        recruiterPage.contactNumber.sendKeys("000000000000");
        recruiterPage.uploadResume(System.getProperty("user.dir") + "/src/main/resources/resume.pdf");
        recruiterPage.keywords.sendKeys("Keyword");
        recruiterPage.notes.sendKeys("Assignment");
        recruiterPage.selectDateAsToday();
        recruiterPage.checkBox.click();
        recruiterPage.saveButton.click();

        UtilityMethods.invisibilityOfElement(recruiterPage.loader, driver);

        UtilityMethods.takeScreenshot(driver, System.getProperty("user.dir") + "/TestScreenShot/Screenshot.png");
        UtilityMethods.generateReports(System.getProperty("user.dir") + "/TestReport/Report.png");
    }
}
