class DH {
    final int tablesize = 10; // size of the table
    int[] keys; // array to store the keys
    int[] values; // array to store the values
    int size; // Number of elements currently stored in the hash table

    public DH() {
        keys = new int[tablesize];
        values = new int[tablesize];
        size = 0;
    }

    // First hash function to compute the index for a key
    int hash(int key) {
        return key % tablesize;
    }

    // Second hash function for double hashing
    int hash2(int key) {
        // Prime number less than tablesize
        int prime = 7;
        return prime - (key % prime);
    }

    // Insertion operation using double hashing
    void insert(int key, int value) {
        int i = hash(key);
        int h2 = hash2(key);

        // Double hash until an empty slot is found
        while (keys[i] != 0 && keys[i] != key) {
            i = (i + h2) % tablesize;
        }

        // If an empty slot is found, insert the key-value pair
        if (keys[i] == 0) {
            keys[i] = key;
            values[i] = value;
            size++;
        } else {
            values[i] = value; // If key already exists, update its value
        }
    }

    public static void main(String[] args) {
        DH hashTable = new DH();
        hashTable.insert(101, 80);
        hashTable.insert(201, 10);
        hashTable.insert(301, 20);
        hashTable.insert(102, 30);
        hashTable.insert(202, 40);
        hashTable.insert(302, 43);
        hashTable.insert(103, 33);
        hashTable.insert(203, 50);
        hashTable.insert(304, 3);
        hashTable.insert(104, 2);

        for (int i = 0; i < hashTable.tablesize; i++) {
            if (hashTable.keys[i] != 0) {
                System.out.println("Key: " + hashTable.keys[i] + ", Value: " + hashTable.values[i]);
            }
        }
    }
}
