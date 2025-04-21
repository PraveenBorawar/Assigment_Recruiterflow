package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class UtilityMethods {

    public static void takeScreenshot(WebDriver driver, String path) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File ssFile = ts.getScreenshotAs(OutputType.FILE);
        File storeFile = new File(path);
        FileUtils.copyFile(ssFile, storeFile);
    }

    public static void generateReports(String path) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Assignment Report");
        reporter.config().setTheme(Theme.DARK);

        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("Tester Name", "Praveen");
        extent.attachReporter(reporter);

        ExtentTest test = extent.createTest("Recruiter Flow");
        test.pass("Success");

        extent.flush();
    }

    public static void invisibilityOfElement(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
