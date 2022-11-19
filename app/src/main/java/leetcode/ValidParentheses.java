package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidParentheses {

    public boolean isValid(String s) {
        List<Character> chars = new ArrayList<>(s.length());
        for (char t : s.toCharArray()) {
            chars.add(t);
        }
        Map<Character, Character> openCloseMap = Map.of('(', ')', '{', '}', '[', ']');
        SortedSet<Integer> indexes = IntStream.range(0, chars.size()).boxed().collect(Collectors.toCollection(TreeSet::new));
        int oldIndexesSize = indexes.size();

        while (oldIndexesSize > 0) {
            Iterator<Integer> iterator = indexes.iterator();
            Set<Integer> toRemove = new HashSet<>();
            Integer prevValue = -1, nextValue;

            while (iterator.hasNext()) {
                if (prevValue == -1) {
                    prevValue = iterator.next();
                    continue;
                }
                nextValue = iterator.next();
                Character closeChar = openCloseMap.getOrDefault(chars.get(prevValue), '-');
                if (closeChar.equals(chars.get(nextValue))) {
                    toRemove.add(prevValue);
                    toRemove.add(nextValue);
                    if(iterator.hasNext()){
                        iterator.next();
                    }
                }

                prevValue = nextValue;
            }

            indexes.removeAll(toRemove);
            if (oldIndexesSize == indexes.size()) {
                return false;
            }
            oldIndexesSize = indexes.size();
        }
        return true;
    }
}
