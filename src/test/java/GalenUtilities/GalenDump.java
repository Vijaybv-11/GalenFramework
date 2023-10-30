package GalenUtilities;

import com.galenframework.browser.Browser;
import com.galenframework.browser.SeleniumBrowser;
import com.galenframework.suite.GalenPageAction;
import com.galenframework.suite.actions.GalenPageActionDumpPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GalenDump {
        public static void main(String[] args) throws Exception {
            String path =  "C:\\Users\\Vijay\\Documents\\GSPEC Files\\digitalseo.gspec";
            String url = "https://wordpress-205471-3653890.cloudwaysapps.com/";
            int width  = 1024;
            int height =768;
            String exportName = "C:\\Users\\Vijay\\Documents\\GSPEC Files\\Fireflink\\SEODumps";
            WebDriver driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(width,height));
            driver.get(url);
            GalenPageAction pageAction = new GalenPageActionDumpPage("Test page", path, exportName);
            Browser browser = new SeleniumBrowser(driver);
            pageAction.execute(null,browser,null,null);
driver.quit();


        }
    }


