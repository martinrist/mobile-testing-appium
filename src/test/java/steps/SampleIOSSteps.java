package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class SampleIOSSteps {

    AppiumDriver<MobileElement> driver;

    @When("^I launch iOS app$")
    public void iLaunchIOSApp() throws Throwable {
        File app = new File("app/TestApp.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(DEVICE_NAME, "iPhone 6 Plus");
        capabilities.setCapability(PLATFORM_VERSION, "12.2");
        capabilities.setCapability(AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(APP, app.getAbsolutePath());

        driver = new AppiumDriver<>(
                new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("^I choose to enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iChooseToEnterAnd(String num1, String num2) {
        driver.findElementByAccessibilityId("IntegerA").sendKeys(num1);
        driver.findElementByAccessibilityId("IntegerB").sendKeys(num2);
    }

    @When("^I tap on Compute Sum$")
    public void iTapOnComputeSum() {
        driver.findElementByAccessibilityId("ComputeSumButton").click();
    }

    @Then("^I should see the result \"([^\"]*)\"$")
    public void iShouldSeeTheResult(String result) {
        Assert.assertEquals(result, driver.findElementByAccessibilityId("Answer").getText());
    }
}
