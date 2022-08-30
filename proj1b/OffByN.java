public class OffByN implements CharacterComparator{
    private int n = 3;
    @Override
    public boolean equalChars(char x, char y)
    {
        return Math.abs(x - y) == n;
    }
}
