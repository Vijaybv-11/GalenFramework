import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.emulation.Emulation;

import java.io.IOException;
import java.util.*;

@Slf4j
public class FireFlinkTest {

    public static void main(String[] args) throws IOException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(414, 896));
       /* DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setDeviceMetricsOverride(390,844,50,true, Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
*/
        /*Map<String, Object>   device= new HashMap<String,Object>();
        device.put("width",414);
        device.put("height",896);
        device.put("deviceScaleFactor",100);
        device.put("mobile", true);
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",device);*/

        driver.get("https://app.fireflink.com");
        LayoutReport layoutReport = Galen.checkLayout(driver, "specs/fireflink.gspec", List.of("desktop"));

        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
        GalenTestInfo test = GalenTestInfo.fromString("FireFlink Signin Page Test");
        test.getReport().layout(layoutReport, "signin Test");
        tests.add(test);


        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        htmlReportBuilder.build(tests, "Reports");

        driver.quit();
    }
}
