import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class test {

    public static void main(String[] args) throws MalformedURLException {

        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", "firefox");



        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
     driver.get("https://www.google.com");


    }
}
