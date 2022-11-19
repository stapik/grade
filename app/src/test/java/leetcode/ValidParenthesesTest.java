package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {

    private final ValidParentheses solution = new ValidParentheses();

    @Test
    public void testTrue() {
        assertTrue(solution.isValid(""));
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("{[]}"));
        assertTrue(solution.isValid("()[]{}"));
        assertTrue(solution.isValid("(()[]{})([])"));
        assertTrue(solution.isValid("{{[]()}({}[]())}"));
    }

    @Test
    public void testFalse() {
        assertFalse(solution.isValid("[)]"));
        assertFalse(solution.isValid("([)]"));
        assertFalse(solution.isValid(")"));
        assertFalse(solution.isValid(")("));
        assertFalse(solution.isValid("(]"));
        assertFalse(solution.isValid("(()[]{})([]"));
        assertFalse(solution.isValid("(()[]{}))([]"));
    }
}
