package OrangeHrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruiterPage extends BasePage {
    public RecruiterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//label[text()='Email']/../following-sibling::div//input")
    public WebElement email;

    @FindBy(xpath = "//label[text()='Contact Number']/../following-sibling::div//input")
    public WebElement contactNumber;

    @FindBy(xpath = "//label[text()='Keywords']/../following-sibling::div//input")
    public WebElement keywords;

    @FindBy(xpath = "//label[text()='Date of Application']/../following-sibling::div//input")
    public WebElement dateOfApplication;

    @FindBy(xpath = "//label[text()='Notes']/../following-sibling::div//textarea")
    public WebElement notes;

    @FindBy(xpath = "//div[text()='Today']")
    WebElement todayDate;

    @FindBy(xpath = "//div[@class='oxd-checkbox-wrapper']")
    public WebElement checkBox;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileField;

    @FindBy(xpath = "//label[text()='Vacancy']/../..//div[@class= 'oxd-select-wrapper']/div")
    WebElement vacancy;

    @FindBy(xpath = "//div[@class='oxd-table-loader']")
    public WebElement loader;

    String vacancyPosition = "//span[normalize-space()='%s']";

    public void selectVacancyPosition(String position){
        vacancy.click();
        driver.findElement(By.xpath(String.format(vacancyPosition, position))).click();
    }

    public void selectDateAsToday() {
        dateOfApplication.click();
        todayDate.click();
    }

    public void uploadResume(String filePath) {
        fileField.sendKeys(filePath);
    }

}
