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