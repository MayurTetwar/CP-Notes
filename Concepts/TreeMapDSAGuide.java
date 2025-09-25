package Concepts;
import java.util.*;

public class TreeMapDSAGuide {
    public static void main(String[] args) {
        // 1. BASIC OPERATIONS
        TreeMap<Integer, String> map = new TreeMap<>();
        
        // Insert elements
        map.put(3, "three");
        map.put(1, "one");
        map.put(5, "five");
        map.put(2, "two");
        map.put(4, "four");
        
        System.out.println("Original map: " + map); // Automatically sorted by key
        
        // 2. RANGE QUERIES (Most Important for CP)
        System.out.println("\n=== RANGE QUERIES ===");
        
        // Get elements in range [2, 4]
        NavigableMap<Integer, String> subMap = map.subMap(2, true, 4, true);
        System.out.println("subMap [2,4]: " + subMap);
        
        // Get elements < 4
        SortedMap<Integer, String> headMap = map.headMap(4);
        System.out.println("headMap < 4: " + headMap);
        
        // Get elements >= 3
        SortedMap<Integer, String> tailMap = map.tailMap(3);
        System.out.println("tailMap >= 3: " + tailMap);
        
        // 3. CEILING AND FLOOR OPERATIONS (Critical for Binary Search-like problems)
        System.out.println("\n=== CEILING/FLOOR OPERATIONS ===");
        
        // Ceiling: smallest key >= given key
        Integer ceiling = map.ceilingKey(3); // Returns 3
        System.out.println("Ceiling of 3: " + ceiling);
        
        Integer ceiling2 = map.ceilingKey(6); // Returns null (no key >= 6)
        System.out.println("Ceiling of 6: " + ceiling2);
        
        // Floor: largest key <= given key
        Integer floor = map.floorKey(3); // Returns 3
        System.out.println("Floor of 3: " + floor);
        
        Integer floor2 = map.floorKey(0); // Returns null (no key <= 0)
        System.out.println("Floor of 0: " + floor2);
        
        // 4. HIGHER AND LOWER OPERATIONS
        System.out.println("\n=== HIGHER/LOWER OPERATIONS ===");
        
        // Higher: smallest key > given key
        Integer higher = map.higherKey(3); // Returns 4
        System.out.println("Higher than 3: " + higher);
        
        // Lower: largest key < given key
        Integer lower = map.lowerKey(3); // Returns 2
        System.out.println("Lower than 3: " + lower);
        
        // 5. FIRST AND LAST OPERATIONS
        System.out.println("\n=== FIRST/LAST OPERATIONS ===");
        
        Integer firstKey = map.firstKey(); // Smallest key
        Integer lastKey = map.lastKey();   // Largest key
        System.out.println("First key: " + firstKey + ", Last key: " + lastKey);
        
        Map.Entry<Integer, String> firstEntry = map.firstEntry();
        Map.Entry<Integer, String> lastEntry = map.lastEntry();
        System.out.println("First entry: " + firstEntry + ", Last entry: " + lastEntry);
        
        // 6. POLL OPERATIONS (Remove and return)
        System.out.println("\n=== POLL OPERATIONS ===");
        TreeMap<Integer, String> tempMap = new TreeMap<>(map);
        
        Map.Entry<Integer, String> polledFirst = tempMap.pollFirstEntry();
        Map.Entry<Integer, String> polledLast = tempMap.pollLastEntry();
        System.out.println("Polled first: " + polledFirst);
        System.out.println("Polled last: " + polledLast);
        System.out.println("Map after polling: " + tempMap);
        
        // 7. DESCENDING OPERATIONS
        System.out.println("\n=== DESCENDING OPERATIONS ===");
        
        NavigableMap<Integer, String> descendingMap = map.descendingMap();
        System.out.println("Descending map: " + descendingMap);
        
        NavigableSet<Integer> descendingKeys = map.descendingKeySet();
        System.out.println("Descending keys: " + descendingKeys);
        
        // 8. PRACTICAL CP EXAMPLES
        System.out.println("\n=== PRACTICAL CP EXAMPLES ===");
        
        // Example 1: Finding closest elements
        TreeMap<Integer, Integer> points = new TreeMap<>();
        points.put(10, 1);
        points.put(20, 1);
        points.put(30, 1);
        points.put(50, 1);
        
        int target = 25;
        Integer closest = findClosest(points, target);
        System.out.println("Closest to " + target + ": " + closest);
        
        // Example 2: Range sum query simulation
        TreeMap<Integer, Integer> prefixSum = new TreeMap<>();
        prefixSum.put(1, 1);
        prefixSum.put(2, 3);
        prefixSum.put(3, 6);
        prefixSum.put(4, 10);
        prefixSum.put(5, 15);
        
        int rangeSum = getRangeSum(prefixSum, 2, 4);
        System.out.println("Sum from index 2 to 4: " + rangeSum);
        
        // Example 3: Count elements in range
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        int count = countInRange(freq, 4, 10);
        System.out.println("Count of elements in range [4, 10]: " + count);
    }
    
    // Helper method: Find closest element to target
    public static Integer findClosest(TreeMap<Integer, Integer> map, int target) {
        Integer floor = map.floorKey(target);
        Integer ceiling = map.ceilingKey(target);
        
        if (floor == null) return ceiling;
        if (ceiling == null) return floor;
        
        return (target - floor <= ceiling - target) ? floor : ceiling;
    }
    
    // Helper method: Range sum using prefix sums
    public static int getRangeSum(TreeMap<Integer, Integer> prefixSum, int left, int right) {
        Integer rightSum = prefixSum.floorEntry(right).getValue();
        Integer leftSum = prefixSum.floorEntry(left - 1).getValue();
        
        return rightSum - (leftSum != null ? leftSum : 0);
    }
    
    // Helper method: Count elements in range
    public static int countInRange(TreeMap<Integer, Integer> freq, int left, int right) {
        NavigableMap<Integer, Integer> subMap = freq.subMap(left, true, right, true);
        return subMap.values().stream().mapToInt(Integer::intValue).sum();
    }
}

/*
MOST IMPORTANT TREEMAP FUNCTIONS FOR DSA & CP:

1. RANGE OPERATIONS:
   - subMap(fromKey, fromInclusive, toKey, toInclusive)
   - headMap(toKey) / headMap(toKey, inclusive)
   - tailMap(fromKey) / tailMap(fromKey, inclusive)

2. BINARY SEARCH OPERATIONS:
   - ceilingKey(key) - smallest key >= key
   - floorKey(key) - largest key <= key
   - higherKey(key) - smallest key > key
   - lowerKey(key) - largest key < key

3. EXTREMES:
   - firstKey() / lastKey()
   - firstEntry() / lastEntry()
   - pollFirstEntry() / pollLastEntry()

4. NAVIGATION:
   - descendingMap()
   - descendingKeySet()

COMMON CP USE CASES:
- Coordinate compression
- Range queries
- Finding closest elements
- Interval scheduling
- Sweep line algorithms
- Binary search on answers
- Maintaining sorted order with duplicates (use TreeMap<Key, Count>)

TIME COMPLEXITY: O(log n) for all operations
SPACE COMPLEXITY: O(n)
*/