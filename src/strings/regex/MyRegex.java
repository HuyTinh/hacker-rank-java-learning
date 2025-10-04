package strings.regex;

public class MyRegex {
    public MyRegex() {

    }

    private final String octet = "(?:25[0-5]|2[0-4]\\d|1\\d{2}|0\\d{2}|\\d{1,2})";

    public final String pattern = "^(" + octet + "\\.){3}" + octet + "$";
}
