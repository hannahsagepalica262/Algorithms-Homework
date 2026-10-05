package ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // Test addToBack and addToFront
        list.addToBack("A");
        list.addToBack("B");
        list.addToBack("C");
        list.addToBack("D");
        list.addToBack("E");
        list.addToBack("F");
        list.addToBack("G");
        list.addToBack("H");
        list.addToBack("I");
        list.addToBack("J");
        list.addToBack("K");
        list.addToBack("L");
        list.addToFront("AA");

        System.out.println("Size after adds: " + list.size()); // Expected: 13
        System.out.println("Array contents: " + Arrays.toString(list.getBackingArray())); 
        // Expected: [AA, A, B, C, D, E, F, G, H, I, J, K, L]

        // Test removeFromFront
        String front = list.removeFromFront();
        System.out.println("Removed from front: " + front); // Expected: AA
        System.out.println("Size after remove: " + list.size()); // Expected: 12
        System.out.println("Array contents: " + Arrays.toString(list.getBackingArray())); 
        // Expected: [A, B, C, D, E, F, G, H, I, J, K, L, null]

        // Test removeFromBack
        String back = list.removeFromBack();
        System.out.println("Removed from back: " + back); // Expected: L
        System.out.println("Size after remove: " + list.size()); // Expected: 11
        System.out.println("Array contents: " + Arrays.toString(list.getBackingArray())); 
        // Expected: [A, B, C, D, E, F, G, H, I, J, K, null, null]
    }
}

