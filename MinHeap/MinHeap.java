import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        if (size == backingArray.length - 1) {
            doubleSize();
        }
        backingArray[size + 1] = data;
        int currIndex = size + 1;
        while (currIndex > 1 && backingArray[currIndex].compareTo(backingArray[currIndex/2]) < 0) {
            T temp = backingArray[currIndex];
            backingArray[currIndex] = backingArray[currIndex/2];
            backingArray[currIndex/2] = temp;
            currIndex = currIndex/2;
        }
        size++;
    }

    private void doubleSize() {
        T[] newArray = (T[]) new Comparable[backingArray.length * 2];
        for (int i = 0; i <= size; i++) {
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty, nothing to removve.");
        }
        T removedData = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        downHeap(1, backingArray, size);
        return removedData;
    }

    private void downHeap(int index, T[] backingArray, int size) {
    int left = 2 * index;
    int right = 2 * index + 1;

    // Base case: No left child means leaf node -> stop
    if (left > size) {
        return;
    }

    // Case 1: Only left child exists
    if (right > size) {
        if (backingArray[index].compareTo(backingArray[left]) > 0) {
            T temp = backingArray[index];
            backingArray[index] = backingArray[left];
            backingArray[left] = temp;
            downHeap(left, backingArray, size);
        }
        return;
    }

    // Case 2: Both children exist, left is smaller or equal
    if (backingArray[left].compareTo(backingArray[right]) <= 0) {
        if (backingArray[index].compareTo(backingArray[left]) > 0) {
            T temp = backingArray[index];
            backingArray[index] = backingArray[left];
            backingArray[left] = temp;
            downHeap(left, backingArray, size);
        }
    } 
    // Case 3: Both children exist, right is smaller
    else {
        if (backingArray[index].compareTo(backingArray[right]) > 0) {
            T temp = backingArray[index];
            backingArray[index] = backingArray[right];
            backingArray[right] = temp;
            downHeap(right, backingArray, size);
        }
    }
}

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}