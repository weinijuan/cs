import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    @Test
    public void testEqualChars()
    {
        CharacterComparator cc = new OffByN(3);
        assertTrue(cc.equalChars('a','d'));
        assertTrue(cc.equalChars('d','a'));
        assertFalse(cc.equalChars('d','b'));

    }
}
