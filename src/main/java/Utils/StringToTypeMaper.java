package Utils;

public class StringToTypeMaper {
    public static BrowserTypes mapParameter(String param) {
        BrowserTypes browserType = BrowserTypes.FireFox;
        switch (param == null ? "" : param) {
            case "chrome":
                browserType = BrowserTypes.Chrome;
                break;
            case "firefox":
                browserType = BrowserTypes.FireFox;
                break;
            default:
                browserType = BrowserTypes.Chrome;
                break;
        }
        return browserType;
    }
}
