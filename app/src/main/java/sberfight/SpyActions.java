package sberfight;

import java.util.Arrays;
import java.util.List;

public class SpyActions {

    public static void main(String[] args) {
        System.out.println(getResult(Arrays.asList("power", "keystrokes", "click", "click", "power", "click", "click", "keystrokes", "click", "click")));
    }

    public static int getResult(List<String> actions) {
        boolean isPower = false;
        boolean isLogin = false;
        int counter = 0;
        int result = 0;

        for (String action : actions) {
            switch (action) {
                case "power":
                    isPower = !isPower;
                    isLogin = false;
                    result += counter / 2;
                    counter = 0;
                    break;
                case "keystrokes":
                    isLogin = true;
                    counter = 0;
                    break;
                case "click":
                    if (isLogin && isPower) {
                        counter++;
                    }
                    break;
            }
        }
        result += counter / 2;

        return result;
    }
}
