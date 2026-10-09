public class HashMapTest {
    public static void main(String[] args) {
        ExternalChainingHashMap<String, Integer> map = new ExternalChainingHashMap<>();

        map.put("1", 1);
        map.put("1", 42);
        map.put("4", 17);
        map.put("7", 89);
        map.put("10", 3);
        map.put("12", 95);
        map.put("15", 28);
        map.put("16", 64);
        map.put("18", 11);
        map.put("19", 73);
        map.put("21", 50);
        map.put("22", 6);

        printTable(map);

        // Get the array using getTable()
    }
    public static void printTable(ExternalChainingHashMap<String, Integer> map) {
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