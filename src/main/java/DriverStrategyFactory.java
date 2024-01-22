public class DriverStrategyFactory {
    public static DriverStrategy createDiver(String startegy){
        switch (startegy){
            case "chrome":
                return new Chrome();
            case "FireFox":
                return new FireFox();
            case "Phantomjs":
                return new PhantomJS();
            default:
                return null;
        }
    }
}
