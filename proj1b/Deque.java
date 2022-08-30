public interface Deque<T> {
    int size();
    default boolean isEmpty()
    {
        return size() == 0;
    }
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    void printDeque();
    T get(int index);
}
