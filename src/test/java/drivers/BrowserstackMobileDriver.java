package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", "");
        mutableCapabilities.setCapability("browserstack.key", "");

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", "");

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", "Google Pixel 7");
        mutableCapabilities.setCapability("os_version", "14.0");

        // Set other BrowserStack mutableCapabilities
        mutableCapabilities.setCapability("project", "");
        mutableCapabilities.setCapability("build", "");
        mutableCapabilities.setCapability("name", "");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired mutableCapabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(""), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}