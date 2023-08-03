import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class GalenExampleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("https://arrka.com/");
    }

    @AfterMethod
        public void tearDown()
        {
            driver.quit();
        }

        @Test
        public void homePageLayoutTest() throws IOException {
            //Create a layoutReport object
            //checkLayout function checks the layout and returns a LayoutReport object
            LayoutReport layoutReport = Galen.checkLayout(driver, "specs/Arrka.gspec", Arrays.asList("desktop"));

            //Create a tests list
            List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

            //Create a GalenTestInfo object
            GalenTestInfo test = GalenTestInfo.fromString("Arkka Testing");

            //Get layoutReport and assign to test object
            test.getReport().layout(layoutReport, "check Arkka homepage layout");

            //Add test object to the tests list
            tests.add(test);

            //Create a htmlReportBuilder object
            HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

            //Create a report under /target folder based on tests list
            htmlReportBuilder.build(tests, "Reports");

        }
}
