import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class LFUCache {
    private Map<Integer, Integer> keyToVal; // Mapping from key to value
    private Map<Integer, Integer> keyToFreq; // Mapping from key to frequency
    private Map<Integer, Set<Integer>> freqToKeys; // Mapping from frequency to a set of keys
    private int capacity;
    private int minFreq; // Minimum frequency observed

    public LFUCache(int capacity) {
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1; // Key not present in the cache
        }

        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1); // Increase frequency of the accessed key
        freqToKeys.get(freq).remove(key); // Remove from current frequency bucket
        if (freq == minFreq && freqToKeys.get(freq).isEmpty()) {
            minFreq++; // If the current frequency bucket becomes empty, update minFreq
        }
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key); // Add to new frequency bucket
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (get(key) != -1) { // Key already present in the cache
            keyToVal.put(key, value); // Update value
            return;
        }

        if (keyToVal.size() >= capacity) { // Cache is full, evict LFU item
            int evictKey = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(evictKey);
            keyToVal.remove(evictKey);
            keyToFreq.remove(evictKey);
        }

        keyToVal.put(key, value); // Add new key-value pair
        keyToFreq.put(key, 1); // Set frequency to 1
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key); // Add to frequency bucket 1
        minFreq = 1; // Minimum frequency becomes 1
    }
}

public class LFUcaching {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2); // Capacity of 2

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}

// Algorithm:

// Initialize three data structures:
// keyToVal: A map from keys to their corresponding values.
// keyToFreq: A map from keys to their frequencies.
// freqToKeys: A map from frequencies to sets of keys with that frequency.
// Implement get operation:
// If the key is not present in the cache, return -1.
// Increment the frequency of the accessed key in keyToFreq.
// Remove the key from its current frequency bucket in freqToKeys.
// If the current frequency bucket becomes empty and its frequency is equal to minFreq, increment minFreq.
// Add the key to the next frequency bucket in freqToKeys.
// Return the value associated with the key.
// Implement put operation:
// If the cache is full:
// Evict the LFU (least frequently used) item:
// Get the first key from the bucket with frequency minFreq.
// Remove the key from keyToVal, keyToFreq, and its frequency bucket in freqToKeys.
// Add the new key-value pair to keyToVal.
// Set the frequency of the new key to 1 in keyToFreq.
// Add the new key to the frequency bucket 1 in freqToKeys.
// If necessary, update minFreq to 1.
// Handle special cases:
// If the cache capacity is less than or equal to 0, return immediately in put operation.
// When getting a key, return -1 if it is not found in the cache.

