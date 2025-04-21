package OrangeHrmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(@class,'oxd-text') and text()='Recruitment']")
    public WebElement clickRecruitment;

    @FindBy(xpath = " //span[@class='oxd-topbar-header-breadcrumb']/h6")
    public WebElement dashboardTitle;
}
