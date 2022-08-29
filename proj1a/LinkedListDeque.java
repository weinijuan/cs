public class LinkedListDeque<T> {
    public static class Node<T> {
        public T data;
        public Node<T> next, prev;

        private Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    private Node<T> head;
    private Node<T> end;
    private int size;

    /**
     * sentry node is to prevent sentry.next become null.next ,so we should new node to sentry
     * and don't set sentry.data and sentry.next = null because sentry is null if sentry don't new;
     */
    public LinkedListDeque() {
        head = new Node<T>(null, null, null);
        end = new Node<T>(null, null, null);
        head.next = end;
        end.prev = head;
        size = 0;
    }

    //    public LinkedListDeque(LinkedListDeque other)
//    {
////        head = new Node<T>(null,null,null);
////        end = new Node<T>(null,null,null);
////        head.next = end.prev;
////        size = 0;
//        this();
//        if (other != null)
//        {
//            Node<T> temp = other.head.next;
//            for (int i = 0; i < other.size; i++)
//            {
//                addLast(temp.data);
//                temp = temp.next;
//            }
//        }
//    }
    public void addFirst(T item) {
        size++;
        head.next = new Node<>(item, head, head.next);
        head.next.next.prev = head.next;
    }

    public void addLast(T item) {
        size++;
        end.prev = new Node<>(item, end.prev, end);
        end.prev.prev.next = end.prev;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> temp = head.next;
        while (temp.next != null)  // also can use size
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public T removeFirst() {
        size--;
        T temp = head.next.data;
        head.next.data = null; // actually this is no useful because garbage collect will eat this node;
        head.next = head.next.next;
        head.next.prev = head;
        return temp;
    }

    public T removeLast() {
        size--;
        T temp = end.prev.data;
        end.prev = end.prev.prev;
        end.prev.next = end;
        return temp;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> temp = head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursive(index, head.next);
    }

    private T getRecursive(int index, Node<T> node) {
        if (index == 0) {
            return node.data;
        }
        return getRecursive(index - 1, node.next);
    }


}
/**
 * public void addFirst(T item): Adds an item of type T to the front of the deque.
 * public void addLast(T item): Adds an item of type T to the back of the deque.
 * public boolean isEmpty(): Returns true if deque is empty, false otherwise.
 * public int size(): Returns the number of items in the deque.
 * public void printDeque(): Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.
 * public T removeFirst(): Removes and returns the item at the front of the deque. If no such item exists, returns null.
 * public T removeLast(): Removes and returns the item at the back of the deque. If no such item exists, returns null.
 * public T get(int index): Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
 * public LinkedListDeque(LinkedListDeque other): Creates a deep copy of other.
 * Creating a deep copy means that you create an entirely new LinkedListDeque, with the exact same items as other. However, they should be different objects, i.e. if you change other, the new LinkedListDeque you created should not change as well. (Edit 2/6/2018: A walkthrough that provides a solution for this copy constructor is available at https://www.youtube.com/watch?v=JNroRiEG7U4)
 * public T getRecursive(int index): Same as get, but uses recursion.
 * You may add any private helper classes or methods in LinkedListDeque.java if you deem it necessary.
 */
/**public LinkedListDeque(LinkedListDeque other): Creates a deep copy of other.
 Creating a deep copy means that you create an entirely new LinkedListDeque, with the exact same items as other. However, they should be different objects, i.e. if you change other, the new LinkedListDeque you created should not change as well. (Edit 2/6/2018: A walkthrough that provides a solution for this copy constructor is available at https://www.youtube.com/watch?v=JNroRiEG7U4)
 public T getRecursive(int index): Same as get, but uses recursion.
 You may add any private helper classes or methods in LinkedListDeque.java if you deem it necessary.
 * */