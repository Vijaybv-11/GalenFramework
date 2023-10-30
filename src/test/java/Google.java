import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.*;

@Slf4j
public class Google {

    public static void main(String[] args) throws IOException, InterruptedException {

        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(414, 896));

        driver.get("https://www.google.com");
        Thread.sleep(5000);
        LayoutReport layoutReport = Galen.checkLayout(driver, "specs/google.gspec", List.of("desktop"));

        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
        GalenTestInfo test = GalenTestInfo.fromString("FireFlink Signin Page Test");
        test.getReport().layout(layoutReport, "signin Test");
        tests.add(test);


        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        htmlReportBuilder.build(tests, "Reports");

        driver.close();
    }
}
