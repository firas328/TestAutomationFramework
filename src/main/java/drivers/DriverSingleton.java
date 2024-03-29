package drivers;

import drivers.strategies.DriverStrategy;
import drivers.strategies.DriverStrategyFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance ;
    private static WebDriver driver;
    private DriverSingleton(String driver) {
        instanciate(driver);
    }

    public static DriverSingleton getInstance(String driver) {
        if (instance == null) {
            return new DriverSingleton(driver);
        }
        return instance;
    }

    public WebDriver instanciate(String strategy) {
        DriverStrategy driverStrategy = DriverStrategyFactory.createDiver(strategy)  ;
        driver=driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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