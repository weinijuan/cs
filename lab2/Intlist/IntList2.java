public class IntList2
{
    int data;
    IntList2 next;
    public IntList2()
    {

    }
    public IntList2(int d,IntList2 i)
    {
        data = d;
        next = i;
    }
    public void squareList(IntList2 ls)
    {
        while (ls != null)
        {
            ls.data *= ls.data;
            ls = ls.next;
        }
    }
    /** non-destructive:need new
     * */
    public static IntList2 squareList1(IntList2 ls)
    {
        if (ls == null)
        {
            return null;
        }
        return new IntList2(ls.data* ls.data,squareList1(ls.next));
    }
    public IntList2 squareList2()
    {
        if (this.next == null)
        {
            return null;
        }
        return new IntList2(data* data,next.squareList2());
    }
    public IntList2 squareList3(IntList2 ls)
    {
        if (ls == null)
        {
            return null;
        }
        IntList2 B = new IntList2(ls.data,null);
        IntList2 C = B;
        while (ls.next != null)
        {
            ls = ls.next;
            B.next = new IntList2(ls.data,null);
            B = B.next;
        }
        return C;
    }
    /** destructive:don't use new
     * */
    public static IntList2 square(IntList2 ls)
    {
//        if (ls == null)
//        {
//            return null;
//        }
        IntList2 ptr = ls;
        while (ptr != null)
        {
            ptr.data *= ptr.data;
            ptr = ptr.next;
        }
        return ls;

    }

    public static void main(String[] args)
    {
//        IntList2 ls = new IntList2(10,null);
//        ls.next = new IntList2(30,null);
//        ls.next.next = new IntList2(40,null);
//        System.out.println(ls.data);
//        System.out.println(ls.next.data);
        IntList2 ls = new IntList2(10,null);
        ls = new IntList2(20, ls);
        ls = new IntList2(30, ls);
    }
}
