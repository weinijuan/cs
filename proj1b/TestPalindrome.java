import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome()
    {
        Palindrome p = new Palindrome();
        assertTrue(p.isPalindrome("a"));
        assertTrue(p.isPalindrome(""));
        assertTrue(p.isPalindrome("aba"));
        assertTrue(p.isPalindrome("!a!"));
        assertFalse(p.isPalindrome("aat"));
        assertFalse(p.isPalindrome("cat"));
        assertFalse(p.isPalindrome("zansan"));
        assertFalse(p.isPalindrome("Aa"));
    }
    @Test
    public void testIsPalindrome2()
    {
        Palindrome p = new Palindrome();
        CharacterComparator cc = new OffByOne();
        assertTrue(p.isPalindrome("a", cc));
        assertTrue(p.isPalindrome("acb",cc));
        assertTrue(p.isPalindrome("aihb",cc));
        assertFalse(p.isPalindrome("abba",cc));
        assertTrue(p.isPalindrome("flake    ",cc));

    }
    @Test
    public void testIsPalindrome3()
    {
        Palindrome p = new Palindrome();
        CharacterComparator cc = new OffByN(3);
        assertTrue(p.isPalindrome("ad",cc));
        assertTrue(p.isPalindrome("a",cc));
        assertTrue(p.isPalindrome("",cc));
        assertTrue(p.isPalindrome("aed",cc));
        assertTrue(p.isPalindrome("aebd",cc));
        assertFalse(p.isPalindrome("abba",cc));
    }
}
