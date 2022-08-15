package com.smartdec.appscreener.managers;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static com.smartdec.appscreener.utils.PropConst.*;


public class DriverManager {
//    private WebDriver driver;
    private static DriverManager INSTANCE = null;
    private final TestPropManager props = TestPropManager.getTestPropManager();


    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

//    public WebDriver getDriver() {
//        if (driver == null) {
//            initDriver();
//        }
//        return driver;
//    }

//    public WebDriver getSelenideDriver(){
//        if (driver == null){
//            driver = WebDriverRunner.getWebDriver();
//        }
//           return driver;
//    }


//    public void quitDriver() {
//        if (driver != null) {
//            driver.close();
//            driver = null;
//        }
//    }

//    private void initDriver() {
//        switch (props.getProperty(TYPE_BROWSER)) {
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", props.getProperty(PATH_GEKO_DRIVER));
//                driver = new FirefoxDriver();
//                break;
//            case "chrome":
//                ChromeOptions options = new ChromeOptions();
//                System.setProperty("webdriver.chrome.driver", props.getProperty(PATH_CHROME_DRIVER_WINDOWS));
//                driver = new ChromeDriver(options);
//                //driver.get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
//                break;
//            case "remote":
//                DesiredCapabilities capabilities = new DesiredCapabilities();
//                capabilities.setBrowserName("chrome");
//                capabilities.setVersion("73.0");
//                capabilities.setCapability("enableVNC", true);
//                capabilities.setCapability("enableVideo", false);
//                try {
//                    driver = new RemoteWebDriver(
//                            URI.create("http://selenoid.appline.ru:4445/wd/hub/").toURL(),
//                            capabilities);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
//                break;
//            default:
//                Assertions.fail("Типа браузера '" + props.getProperty(TYPE_BROWSER) + "' не существует во фреймворке");
//        }

//    }




}