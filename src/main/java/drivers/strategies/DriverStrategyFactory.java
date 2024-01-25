package drivers.strategies;
import utils.Constant;

public class DriverStrategyFactory {
    public static DriverStrategy createDiver(String startegy){
        switch (startegy){
            case Constant.CHROME:
                return new Chrome();
            case Constant.FIRFOX:
                return new FireFox();
            case Constant.PANTOMJS:
                return new PhantomJS();
            default:
                return null;
        }
    }
}
