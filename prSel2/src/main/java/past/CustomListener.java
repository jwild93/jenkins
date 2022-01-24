package past;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileOutputStream;
import java.io.IOException;

public class CustomListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Test6 baseTest = (Test6) result.getInstance();
        TakesScreenshot scr = ((TakesScreenshot) baseTest.driver1);
        byte[] screenshot = scr.getScreenshotAs(OutputType.BYTES);

        String fileName = "screenshot.png";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}