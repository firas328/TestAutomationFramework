import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance ;
    private static WebDriver driver;
    private DriverSingleton() {
        instanciate("chrome");
    }

    public static DriverSingleton getInstance() {
        if (instance == null) {
            return new DriverSingleton();
        }
        return instance;
    }

    public WebDriver instanciate(String strategy) {
        DriverStrategy driverStrategy = DriverStrategyFactory.createDiver(strategy)  ;
        driver=driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void close(){
        driver.close();
    }
    public WebDriver getDriver(){
        return driver;
    }
}