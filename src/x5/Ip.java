package x5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ip {

    public static void main(String[] args) {
        System.out.println(isValid("192.168.5.0"));
        System.out.println(isValid("192.168.5.1230"));
    }

    public static boolean isValid(String s) {

        Pattern pattern = Pattern.compile("([0-9{1,3}]{1,3}[.]){3}[0-9{1,3}]{1,3}");
        Matcher matcher = pattern.matcher(s);
        return matcher.groupCount() == 1 && matcher.matches();
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }
}
