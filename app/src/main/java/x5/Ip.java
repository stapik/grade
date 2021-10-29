package x5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ip {

    public static boolean isValid(String s) {
        Pattern pattern = Pattern.compile("([0-9{1,3}]{1,3}[.]){3}[0-9{1,3}]{1,3}");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
