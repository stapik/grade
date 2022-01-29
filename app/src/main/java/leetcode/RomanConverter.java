package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanConverter {

    public int romanToInt(String s) {
        Map<Character, Integer> rMap = new HashMap<>();
        rMap.put('I', 1);
        rMap.put('V', 5);
        rMap.put('X', 10);
        rMap.put('L', 50);
        rMap.put('C', 100);
        rMap.put('D', 500);
        rMap.put('M', 1000);
        char[] symbols = s.toCharArray();
        int result = 0, nextIdx;

        for(int i=0; i < symbols.length; i++){
            nextIdx = symbols.length <= i + 1 ? -1 : i + 1;

            if(nextIdx > -1 && rMap.get(symbols[i]) < rMap.get(symbols[nextIdx])){
                result += rMap.get(symbols[nextIdx]) - rMap.get(symbols[i]);
                i++;
            } else {
                result += rMap.get(symbols[i]);
            }
        }

        return result;
    }
}
