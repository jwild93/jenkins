package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pageObject.pages.BasePage;

import java.io.FileOutputStream;
import java.io.IOException;

import static pageObject.pages.BasePage.getDriver;

public class CustomListener implements ITestListener {

    @Override
    @Attachment(value = "Test failed screenshot", type = "image/png")
    public void onTestFailure(ITestResult result) {
        TakesScreenshot scr = ((TakesScreenshot) getDriver());
        byte[] screenshot = scr.getScreenshotAs(OutputType.BYTES);

        String fileName = "screenshot.png";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
