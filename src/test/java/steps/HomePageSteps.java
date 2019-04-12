package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class HomePageSteps {

    private AppiumDriver<MobileElement> driver;

    @When("^I launch Quikr app$")
    public void iLaunchQuikrApp() throws Throwable {

        File app = new File("app/quikr.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(DEVICE_NAME, "Nexus6");
        capabilities.setCapability(APP, app.getAbsolutePath());

        driver = new AppiumDriver<>(
                new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("I choose to log in using Google")
    public void iChooseToLogInUsingGoogle() {
        driver.findElement(By.id("sign_in_button")).click();
    }
}
