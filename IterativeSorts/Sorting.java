import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        int stopIndex = arr.length;
        while (stopIndex > 1) {
            int lastSwap = 0;
            for (int i = 0; i < stopIndex - 1; i++) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    lastSwap = i + 1;
                }  
            }
            stopIndex = lastSwap;
        }     
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        for (int insertIndex = arr.length - 1; insertIndex >= 0; insertIndex--) {
            int maxValueIndex = 0;
            for (int i = 1; i <= insertIndex; i++) {
                if (comparator.compare(arr[i], arr[maxValueIndex]) > 0) {
                    maxValueIndex = i;
                }
            }
            T temp = arr[insertIndex];
            arr[insertIndex] = arr[maxValueIndex];
            arr[maxValueIndex] = temp;
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        for (int i = 1; i < arr.length; i++) {
            T curr = arr[i];
            int compareIndex = i - 1;
            
            while (compareIndex >= 0 && comparator.compare(arr[compareIndex], curr) > 0) {
                arr[compareIndex + 1] = arr[compareIndex];
                compareIndex--;
            }
            
            arr[compareIndex + 1] = curr;
        }
    }
}