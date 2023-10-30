import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DigitalSeo {

    public static void main(String[] args) throws IOException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(414, 896));
        driver.get("https://wordpress-205471-3653890.cloudwaysapps.com/");
        LayoutReport layoutReport = Galen.checkLayout(driver, "specs/digitalseo.gspec", List.of("desktop"));

        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
        GalenTestInfo test = GalenTestInfo.fromString("DigitalSeo  Page Test");
        test.getReport().layout(layoutReport, "SEo Test");
        tests.add(test);


        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        htmlReportBuilder.build(tests, "Reports");

//        driver.quit();
    }
    }

