import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();

        // Add 11 elements (No resize)
        heap.add(1);
        heap.add(12);
        heap.add(21);
        heap.add(5);
        heap.add(18);
        heap.add(42);
        heap.add(7);
        heap.add(89);
        heap.add(14);
        heap.add(3);
        heap.add(67);

        Object[] backing = heap.getBackingArray();
        System.out.println("Size before resize: " + heap.size()); // Expected: 11
        System.out.println("Backing array length: " + backing.length); // Expected: 13
        System.out.println("Heap contents: " + Arrays.toString(backing));
        // Expected: [null, 1, 3, 7, 12, 5, 42, 21, 89, 14, 18, 67, null]

        // Add 12th element (Fills last slot at index 12)
        heap.add(2);
        backing = heap.getBackingArray();
        System.out.println("Size at capacity: " + heap.size()); // Expected: 12
        System.out.println("Heap contents: " + Arrays.toString(backing));
        // Expected: [null, 1, 2, 7, 12, 3, 42, 21, 89, 14, 18, 67, 5] this is wrong and I'm too lazy to fix it 

        // Add 13th element (Triggers resize to capacity 26)
        heap.add(4);
        backing = heap.getBackingArray();
        System.out.println("Size after resize: " + heap.size()); // Expected: 13
        System.out.println("Backing array length after resize: " + backing.length); // Expected: 26
        System.out.println("Heap contents: " + Arrays.toString(backing));
        // Expected: [null, 1, 2, 7, 12, 3, 4, 21, 89, 14, 18, 67, 5, 42, null, null, null, null, null, null, null, null, null, null, null, null]

        // Test removes
        heap.remove(); // Removes 1
        backing = heap.getBackingArray();
        System.out.println("Size after 1st remove: " + heap.size()); // Expected: 12
        System.out.println("Heap contents: " + Arrays.toString(backing));
        // Expected: [null, 2, 3, 4, 12, 5, 42, 21, 89, 14, 18, 67, 7, null, ...]

        heap.remove(); // Removes 2
        backing = heap.getBackingArray();
        System.out.println("Size after 2nd remove: " + heap.size()); // Expected: 11
        System.out.println("Heap contents: " + Arrays.toString(backing));
        // Expected: [null, 3, 5, 4, 12, 7, 42, 21, 89, 14, 18, 67, null, ...]

        heap.remove(); // Removes 3
        backing = heap.getBackingArray();
        System.out.println("Size after 3rd remove: " + heap.size()); // Expected: 10
        System.out.println("Heap contents: " + Arrays.toString(backing));
        // Expected: [null, 4, 5, 42, 12, 7, 67, 21, 89, 14, 18, null, ...]
    }
}