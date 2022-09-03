public class LinkedListDeque<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next, prev;

        public Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    private Node<T> head;
    private Node<T> end;
    private int size;

    /**
     * sentry node is to prevent sentry.next become null.next ,
     * so we should new node to sentry
     * and don't set sentry.data and sentry.next = null
     * because sentry is null if sentry don't new;
     */
    public LinkedListDeque() {
        head = new Node<T>(null, null, null);
        end = new Node<T>(null, null, null);
        head.next = end;
        end.prev = head;
        size = 0;
    }

        public LinkedListDeque(LinkedListDeque other)
    {
        this();
        if (other != null)
        {
            Node<T> temp = other.head.next;
            for (int i = 0; i < other.size; i++)
            {
                addLast(temp.data);
                temp = temp.next;
            }
        }
    }
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
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        T temp = head.next.data;
        head.next.data = null;
        head.next = head.next.next;
        head.next.prev = head;
        return temp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        T temp = end.prev.data;
        end.prev.data = null;
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

// alt + j