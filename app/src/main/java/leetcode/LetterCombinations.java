package leetcode;

import java.util.*;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        Map<Integer, Character[]> numberSymbolsIndexes = Map.of(
                2, new Character[]{'a', 'b', 'c'},
                3, new Character[]{'d', 'e', 'f'},
                4, new Character[]{'g', 'h', 'i'},
                5, new Character[]{'j', 'k', 'l'},
                6, new Character[]{'m', 'n', 'o'},
                7, new Character[]{'p', 'q', 'r', 's'},
                8, new Character[]{'t', 'u', 'v'},
                9, new Character[]{'w', 'x', 'y', 'z'}
        );
        Map<Integer, Integer> charsCursor = new HashMap<>();
        List<Character[]> characters = new ArrayList<>(digits.length());
        char[] strCharacters = digits.toCharArray();
        for (int i = 0; i < digits.length(); i++) {
            int number = Character.getNumericValue(strCharacters[i]);
            if (number == 0 || number == 1) {
                continue;
            }
            characters.add(numberSymbolsIndexes.get(number));
            charsCursor.put(i, 0);
        }
        if(characters.size() == 0){
            return List.of();
        }

        int[] exitCursor = new int[]{0, characters.get(0).length - 1};
        int[] cursor = new int[]{characters.size() - 1, 0};

        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < charsCursor.size(); j++) {
                sb.append(characters.get(j)[charsCursor.get(j)]);
            }
            result.add(sb.toString());

            if (Arrays.equals(cursor, exitCursor)) {
                break;
            }

            if (cursor[1] + 1 == characters.get(cursor[0]).length) {
                cursor[0] = cursor[0] - 1;
            } else {
                charsCursor.put(cursor[0], cursor[1] + 1);
                cursor[0] = charsCursor.size() - 1;
            }
            cursor[1] = charsCursor.get(cursor[0]);
            charsCursor.put(cursor[0], cursor[1]);
            charsCursor.entrySet().stream().filter(t -> t.getKey() > cursor[0]).forEach(t -> t.setValue(0));
        }

        return result.stream().distinct().toList();
    }
}
