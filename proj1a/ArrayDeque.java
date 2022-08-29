//public class ArrayDeque<T> {
//    private T[] ar;
//    private int size;
//    private int head;
//    private int end;
//
//    /**
//     * head is index of first item
//     */
//    public ArrayDeque() {
//        ar = (T[]) new Object[8];
//        head = 0;
//        end = 0;
//        size = 0;
//    }
//    /** This is copy construct function
//     * */
////    public ArrayDeque(ArrayDeque other) {
////        if (other != null) {
////            this.ar = (T[]) new Object[other.ar.length];
////            System.arraycopy(other.ar, 0, this.ar, 0, ar.length);
////            this.head = other.head;
////            this.end = other.end;
////            this.size = other.size;
////        } else {
////            ar = (T[]) new Object[8];
////            head = 0;
////            end = 0;
////            size = 0;
////        }
////    }
//    /**
//     * in resize function head can't equal to end
//     */
//    private void resize(double factor) {
//        int newLength = (int) (ar.length * factor);
//        T[] temp = (T[]) new Object[newLength];
//        if (head < end) {
//            System.arraycopy(ar, head, temp, 0, size);
//        } else {
//            System.arraycopy(ar, head, temp, 0, size - end - 1);
//            System.arraycopy(ar, 0, temp, size - end - 1, end + 1);
//        }
//        ar = temp;
//        head = 0;
//        end = size - 1;
//    }
//
//    public void addFirst(T item) {
//        if (size == 0) {
//            ar[0] = item;
//            size++;
//        } else {
//            if (size == ar.length) {
//                resize(2);
//            }
//            size++;
//            if (head == 0) {
//                head = ar.length - 1;
//            } else {
//                head--;
//            }
//            ar[head] = item;
//        }
//    }
//
//    public void addLast(T item) {
//        if (size == 0) {
//            ar[0] = item;
//            size++;
//        } else {
//            if (size == ar.length) {
//                resize(2);
//            }
//            size++;
//            if (end == ar.length - 1) {
//                end = 0;
//            } else {
//                end++;
//            }
//            ar[end] = item;
//        }
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public T removeFirst() {
//        if ((double) size / ar.length < 0.25 && ar.length >= 16) {
//            resize(0.5);
//        }
//        size--;
//        T temp = ar[head];
//        ar[head] = null;
//        if (head == ar.length - 1) {
//            head = 0;
//        } else if (size == 0) {
//            head = 0;
//        } else {
//            head++;
//        }
//        return temp;
//    }
//
//    public T removeLast() {
//        if (size == 0) {
//            end = head = 0;
//            return null;
//        }
//        if ((double) size / ar.length < 0.25 && ar.length >= 16) {
//            resize(0.5);
//        }
//        size--;
//        T temp = ar[end];
//        ar[end] = null;
//        if (size == 0) {
//            end = 0;
//        } else if (end == 0)
//        {
//            end = ar.length - 1;
//        } else {
//            end--;
//        }
//        return temp;
//    }
//
//    public T get(int index) {
//        if (index < 0 || index >= size) {
//            return null;
//        } else if (head + index > ar.length - 1) {
//            return ar[head + index - ar.length];
//        } else {
//            return ar[head + index];
//        }
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public void printDeque() {
//        if (end > head) {
//            for (int i = head; i <= end; i++) {
//                System.out.print(ar[i] + " ");
//            }
//            System.out.println("");
//        } else if (end < head) {
//            for (int i = head; i < ar.length; i++) {
//                System.out.println(ar[i] + " ");
//            }
//            for (int i = 0; i <= end; i++) {
//                System.out.println(ar[i] + " ");
//            }
//            System.out.println("");
//        }
//    }
//
//}
public class ArrayDeque<T>
{
    private T[] ar;
    private int head;
    private int end;
    private int size;
    public ArrayDeque()
    {
        ar = (T[]) new Object[8];
        head = 0;
        end = ar.length - 1;
        size = 0;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public void addFirst(T item)
    {
        if (size == ar.length - 2)
        {
            resize(2);
        }
        size++;
        ar[head] = item;
        if (head == ar.length - 1) {
            head = 0;
        } else {
            head++;
        }
    }
    public void addLast(T item)
    {
        if (size == ar.length - 2)
        {
            resize(2);
        }
        size++;
        ar[end] = item;
        if (end == 0)
        {
            end = ar.length - 1;
        }
        else
        {
            end--;
        }
    }
    public T removeFirst()
    {
        if (size == 0)
        {
            return null;
        }
        if ((double)size / ar.length <= 0.25 && size >= 16)
        {
            resize(0.5);
        }
        T temp;
        if (head == 0)
        {
            temp = ar[ar.length - 1];
            ar[ar.length - 1] = null;
            head = ar.length - 1;
        }
        else
        {
            temp = ar[head - 1];
            ar[head - 1] = null;
            head--;
        }
        size--;
        return temp;
    }
    public T removeLast()
    {
        if (size == 0)
        {
            return null;
        }
        if ((double)size / ar.length < 0.25 && size >= 16)
        {
            resize(0.5);
        }
        T temp;
        if (end == ar.length - 1)
        {
            temp = ar[0];
            ar[0] = null;
            end = 0;
        }
        else
        {
            temp = ar[end + 1];
            ar[end + 1] = null;
            end++;
        }
        size--;
        return temp;
    }
    public T get(int index)
    {
        if (index < 0 || index >= size)
        {
            return null;
        }
        else if (head < end && index >= head)
        {
            return ar[(ar.length - 1) - (index - head)];
        }
        else
        {
            return ar[head - 1 - index];
        }
    }
    public void printDeque()
    {
        if (size == 0)
        {
            return;
        }
        if (head > end)
        {
            for (int i = head - 1; i > end; i--)
            {
                System.out.println(ar[i]+" ");
            }
            System.out.println("");
        }
        else
        {
            for (int i = head - 1; i >= 0; i--)
            {
                System.out.println(ar[i] + " ");
            }
            for (int i = ar.length - 1; i > end; i--)
            {
                System.out.println(ar[i] + " ");
            }
            System.out.println("");
        }
    }
    private void resize(double factor)
    {
        T[] temp = (T[]) new Object[(int)(factor*ar.length)];
        if (head > end)
        {
            System.arraycopy(ar, end + 1, temp, 0, size);
            end = temp.length - 1;
            head = size;
        }
        else
        {
            System.arraycopy(ar, 0, temp, 0, head);
            System.arraycopy(ar, end + 1, temp,
                    temp.length - (size - head),size - head);
            end = temp.length - (size - head) - 1;
        }
        ar = temp;
    }


}