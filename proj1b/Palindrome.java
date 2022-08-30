public class Palindrome {
    public Deque<Character> wordToDeque(String s)
    {
        Deque<Character> deque = new LinkedListDeque<>() ;
        for (int i = 0; i < s.length(); i++)
        {
            deque.addLast(s.charAt(i));
        }
        return deque;
    }
    public boolean isPalindrome(String s)
    {
        Deque<Character> deque = wordToDeque(s);
        return isPalindrome(deque);
    }
    public boolean isPalindrome(String s,CharacterComparator cc)
    {
        Deque<Character> deque = wordToDeque(s);
        return  isPalindrome(deque, cc);
    }
    private boolean isPalindrome(Deque<Character> deque,CharacterComparator cc)
    {
        if (deque.size() <= 1)
        {
            return true;
        }
        return (cc.equalChars(deque.removeFirst(), deque.removeLast()) && isPalindrome(deque, cc));
    }
    private boolean isPalindrome(Deque<Character> deque)
    {
        if (deque.size() <= 1)
        {
            return true;
        }
        return (deque.removeLast() == deque.removeFirst()) && isPalindrome(deque);
    }


}
