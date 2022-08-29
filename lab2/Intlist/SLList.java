public class SLList
{
    public  class Node
    {
        public int data;
        public Node next;
        public Node(int d,Node n)
        {
            data = d;
            next = n;
        }
        public Node()
        {

        }
    }
    private Node node;
    public SLList(int i)
    {
        node = new Node(i,null);
    }
    public void addFirst(int i)
    {
        node = new Node(i,node);
    }
    public int getFirst()
    {
        return node.data;
    }
    public void addLast(int i)
    {
        Node temp = node;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = new Node(i,null);
    }
    public int  size()
    {
//        Node temp = node;
//        int i = 0;
//        while (temp != null)
//        {
//            i++;
//            temp = temp.next;
//        }
//        return i;
        Node temp = node;
        if (temp.next == null)
        {
            return 1;
        }
        return 1 + ;
    }

    public static void main(String[] args)
    {
        SLList list = new SLList(4);
        list.addFirst(8);
        list.addFirst(10);
        System.out.println(list.getFirst());
    }
}
