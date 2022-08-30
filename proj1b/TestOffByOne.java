import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testEqualChars()
    {
        assertFalse(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('b','b'));
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('b','a'));
        assertTrue(offByOne.equalChars('%','&'));
        assertTrue(offByOne.equalChars('B','A'));
        assertFalse(offByOne.equalChars('A','A'));
        assertFalse(offByOne.equalChars('&','&'));
        assertFalse(offByOne.equalChars('A','a'));
        assertFalse(offByOne.equalChars('&','a'));
        assertFalse(offByOne.equalChars('a','B'));

    }

}