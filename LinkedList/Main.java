public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        System.out.println("--- Testing addToBack & addToFront ---");
        list.addToBack("A");
        list.addToBack("B");
        list.addToBack("C");
        list.addToFront("AA");

        printListDetails(list); 
        // Expected: [AA, A, B, C] | Size: 4 | Head: AA | Tail: C

        System.out.println("\n--- Testing removeFromFront ---");
        String removedFront = list.removeFromFront();
        System.out.println("Removed from front: " + removedFront); // Expected: AA

        printListDetails(list); 
        // Expected: [A, B, C] | Size: 3 | Head: A | Tail: C

        System.out.println("\n--- Testing removeFromBack ---");
        String removedBack = list.removeFromBack();
        System.out.println("Removed from back: " + removedBack); // Expected: C

        printListDetails(list); 
        // Expected: [A, B] | Size: 2 | Head: A | Tail: B

        System.out.println("\n--- Testing Edge Case: Emptying the List ---");
        System.out.println("Removed: " + list.removeFromFront()); // Removes A
        System.out.println("Removed: " + list.removeFromBack());  // Removes B

        printListDetails(list); 
        // Expected: [] | Size: 0 | Head: null | Tail: null
    }

    /**
     * Helper method to print current state, head, tail, and traverse elements.
     */
    private static <T> void printListDetails(SinglyLinkedList<T> list) {
        StringBuilder sb = new StringBuilder("[");
        SinglyLinkedListNode<T> current = list.getHead();
        
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");

        String headData = (list.getHead() != null) ? String.valueOf(list.getHead().getData()) : "null";
        String tailData = (list.getTail() != null) ? String.valueOf(list.getTail().getData()) : "null";

        System.out.println("List contents: " + sb.toString());
        System.out.println("Size: " + list.size() + " | Head: " + headData + " | Tail: " + tailData);
    }
}