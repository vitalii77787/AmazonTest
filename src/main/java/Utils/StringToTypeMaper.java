package Utils;

public class StringToTypeMaper {
    public static BrowserTypes mapParameter(String param) {
        switch (param) {
            case "chrome" :
                return BrowserTypes.Chrome;
            case "firefox" :
                return BrowserTypes.FireFox;
            default:
                return  BrowserTypes.FireFox;
        }
    }
}
