import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr.length <= 1) {
            return;
        }
        int length = arr.length;
        int midIndex = length / 2;
        T[] leftArray = (T[]) new Object[midIndex];
        System.arraycopy(arr, 0, leftArray, 0, midIndex);
        T[] rightArray = (T[]) new Object[length - midIndex];
        System.arraycopy(arr, 0, rightArray, 0,length - midIndex);

        mergeSort(leftArray, comparator);
        mergeSort(rightArray, comparator);

        int i = 0;
        int j = 0;
        while (!(i == length - 1 | j == length - 1)) {
            if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
                arr[i + j] = leftArray[i];
                i++;
            }
            else {
                arr[i + j] = rightArray[j];
                j++;
            }
        }
        while (i < leftArray.length) {
            arr[i + j] = leftArray[i];
            i++;
        }
        while (j < rightArray.length) {
            arr[i + j] = rightArray[j];
            j++;
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, Math.abs(num));
        }
        int k = 0;
        int temp = max;
        while (temp > 0) {
            temp /= 10;
            k++;
        }
        List<Integer>[] buckets = new LinkedList[19];
        for (int i = 0; i < 19; i++) {
            buckets[i] = new LinkedList<>();
        }
        int place = 1;

        for (int iter = 0; iter < k; iter++) {

            // distribute
            for (int i = 0; i < arr.length; i++) {
                int digit = (arr[i] / place) % 10;
                buckets[digit + 9].add(arr[i]);
            }

            // collect
            int idx = 0;
            for (List<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    arr[idx++] = bucket.remove(0);
                }
            }

            // next digit place
            place *= 10;
        }

    }
}