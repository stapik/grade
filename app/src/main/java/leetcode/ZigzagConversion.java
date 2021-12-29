package leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class ZigzagConversion {

    public static void main(String[] args) {
        ZigzagConversion instance = new ZigzagConversion();
        System.out.println(instance.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        List<Deque<Character>> schema = new ArrayList<>(numRows);
        int rowIdx = 0;
        boolean toBottom = true;
        IntStream.range(0, numRows).forEach(i -> schema.add(i, new LinkedList<>()));

        for (int i = 0; i < s.length(); i++) {
            schema.get(rowIdx).add(s.charAt(i));

            if (numRows == 1) {
                continue;
            }

            if (rowIdx == numRows - 1) {
                toBottom = false;
            }
            if (rowIdx == 0) {
                toBottom = true;
            }

            if (toBottom) {
                rowIdx++;
            } else {
                rowIdx--;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        schema.forEach(characters -> characters.forEach(stringBuilder::append));

        return stringBuilder.toString();
    }
}
