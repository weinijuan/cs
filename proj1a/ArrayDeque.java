public class ArrayDeque<T> {
    private T[] ar;
    private int size;
    private int head;
    private int end;

    /**
     * head is index of first item
     */
    public ArrayDeque() {
        ar = (T[]) new Object[8];
        head = 0;
        end = 0;
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        if (other != null) {
            this.ar = (T[]) new Object[other.ar.length];
            System.arraycopy(other.ar, 0, this.ar, 0, ar.length);
            this.head = other.head;
            this.end = other.end;
            this.size = other.size;
        } else {
            ar = (T[]) new Object[8];
            head = 0;
            end = 0;
            size = 0;
        }
    }
    /** an important key is "length = index +1"
     * compute the length then convert index to length
     * compute the index too;
     * */

    /**
     * in resize function head can't equal to end
     */
    private void resize(double factor) {
        int newLength = (int) (ar.length * factor);
        T[] temp = (T[]) new Object[newLength];
        if (head < end) {
            System.arraycopy(ar, head, temp, 0, size);
        } else {
            System.arraycopy(ar, head, temp, 0, size - end - 1);
            System.arraycopy(ar, 0, temp, size - end - 1, end + 1);
        }
//        System.arraycopy(ar,head,temp,0,ar.length-head);
//        System.arraycopy(ar,0,temp,ar.length-head,head);
        ar = temp;
    }

    public void addFirst(T item) {
        if (size == 0) {
            ar[0] = item;
            size++;
        } else {
            if (size == ar.length) {
                resize(2);
            }
            size++;
            if (head == 0) {
                head = ar.length - 1;
            } else {
                head--;
            }
            ar[head] = item;
        }

    }

    public void addLast(T item) {
        if (size == 0) {
            ar[0] = item;
            size++;
        } else {
            if (size == ar.length) {
                resize(2);
            }
            size++;
            if (end == ar.length - 1) {
                end = 0;
            } else {
                end++;
            }
            ar[end] = item;
        }

//        if (head+size <= ar.length)
//        {
//            ar[head+size-1] = item;
//        }
//        else
//        {
//            ar[head+size-1-ar.length] = item;
//        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if ((double) size / ar.length < 0.25 && ar.length >= 16) {
            resize(0.5);
        }
        size--;
        T temp = ar[head];
        ar[head] = null;
        if (head == ar.length - 1) {
            head = 0;
        } else {
            head++;
        }
        return temp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if ((double) size / ar.length < 0.25 && ar.length >= 16) {
            resize(0.5);
        }
        size--;
        T temp = ar[end];
        ar[end] = null;
        if (end == 0) {
            end = ar.length - 1;
        } else {
            end--;
        }
        return temp;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (head + index > ar.length - 1) {
            return ar[head + index - ar.length];
        } else {
            return ar[head + index];
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (end > head) {
            for (int i = head; i <= end; i++) {
                System.out.print(ar[i] + " ");
            }
            System.out.println("");
        } else if (end < head) {
            for (int i = head; i < ar.length; i++) {
                System.out.println(ar[i] + " ");
            }
            for (int i = 0; i <= end; i++) {
                System.out.println(ar[i] + " ");
            }
            System.out.println("");
        }
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
 */
