package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        List<char[]> charsList = new ArrayList<>(strs.length);
        int i = 0;
        char currentChar;
        boolean charExists;

        for(String s: strs){
            charsList.add(s.toCharArray());
        }

        while(true){

            if(charsList.get(0).length <= i){
                break;
            }

            currentChar = charsList.get(0)[i];
            charExists = true;

            for(char[] chars: charsList){
                if (chars.length <= i || chars[i] != currentChar) {
                    charExists = false;
                    break;
                }
            }

            if(charExists){
                sb.append(currentChar);
            } else {
                break;
            }

            i++;
        }

        return sb.toString();
    }
}
