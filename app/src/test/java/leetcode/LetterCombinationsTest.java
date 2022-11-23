package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LetterCombinationsTest {

    private final LetterCombinations solution = new LetterCombinations();

    @Test
    public void test() {
        assertEquals(solution.letterCombinations("23"), List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assertEquals(solution.letterCombinations("1"), List.of());
        assertEquals(solution.letterCombinations(""), List.of());
        assertEquals(solution.letterCombinations("2"), List.of("a", "b", "c"));
        assertEquals(solution.letterCombinations("3"), List.of("d", "e", "f"));
        assertEquals(solution.letterCombinations("8"), List.of("t", "u", "v"));
        assertEquals(solution.letterCombinations("56"), List.of("jm", "jn", "jo", "km", "kn", "ko", "lm", "ln", "lo"));
    }
}
