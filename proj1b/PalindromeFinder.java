/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc = new OffByN(3);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }
    }
}

/**
 * Create a class called OffByOne that implements CharacterComparator.
 * Add tests to TestOffByOne for the equalChars method in the OffByOne class.
 * Complete the equalChars method and verify that it works.
 * Add a new method that overloads isPalindrome.
 * Add tests to TestPalindrome that tests your new method in isPalindrome. It’s ok to use new OffByOne() for these tests.
 * Complete the new method in isPalindrome and verify that it works.
 * */