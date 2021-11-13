package yandex.b5;

import java.io.IOException;

public class Brackets {

    public static void main(String[] args) throws IOException {
        int countOpen = 0, countClose = 0, open = '(', close = ')', charCode;

        while ((charCode = System.in.read()) != -1) {
            if (charCode == open) {
                countOpen++;
            } else if (charCode == close && countOpen > countClose && countOpen > 0) {
                countClose++;
            } else if(charCode == 10){
                break;
            } else {
                countClose = -1;
                break;
            }
        }

        System.out.println(countOpen == countClose ? "YES" : "NO");
    }
}
