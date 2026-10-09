public class Main {
    public static void main(String[] args) {
        ExternalChainingHashMap<String, Integer> map = new ExternalChainingHashMap<>();

        // ... perform your map.put() or map.remove() calls here ...

        // Get the array using getTable()
        ExternalChainingMapEntry<String, Integer>[] table = map.getTable();

        System.out.println("=== Backing Table (Capacity: " + table.length + ", Size: " + map.size() + ") ===");
        
        for (int i = 0; i < table.length; i++) {
            System.out.print("Index " + i + ": ");
            if (table[i] == null) {
                System.out.println("null");
            } else {
                ExternalChainingMapEntry<String, Integer> curr = table[i];
                while (curr != null) {
                    System.out.print("[" + curr.getKey() + " : " + curr.getValue() + "]");
                    if (curr.getNext() != null) {
                        System.out.print(" -> ");
                    }
                    curr = curr.getNext();
                }
                System.out.println();
            }
        }
    }
}

