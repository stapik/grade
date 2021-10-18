package yandex.b1;

import java.io.*;

public class Dates {

    private static String[] readInputValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        return str.split(" ");
    }

    public static void main(String[] args) throws IOException {
        String[] dateItems = readInputValues();
        int x = Integer.parseInt(dateItems[0]), y = Integer.parseInt(dateItems[1]);
        if(x == y){
            System.out.println(1);
        } else {
            System.out.println(x > 12 && y > 12 || x < 13 && y < 13 ? 0 : 1);
        }
    }
}
