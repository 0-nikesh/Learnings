//13. Implement quadratic probing while building a hash map. (Only write code till insertion)
class QP {
    static final int tablesize = 10; // size of the table
    static int[] keys; // array to store the keys
    static int[] values; // array to store the values
    static int size; // Number of elements currently stored in the hash table

    public QP() {
        keys = new int[tablesize];
        values = new int[tablesize];
        size = 0;
    }

    // Hash function to compute the index for a key
    static int hash(int key) {
        return key % tablesize;
    }

    // Insertion operation using quadratic probing
    void insert(int key, int value) {
        int i = hash(key);
        int originalIndex = i;
        int k = 1;

        // Quadratically search for the next available slot
        while (keys[i] != 0 && keys[i] != key) {
            i = (originalIndex + k * k) % tablesize;
            k++;
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
        QP hashTable = new QP();
        hashTable.insert(35, 80);
        hashTable.insert(5, 10);
        hashTable.insert(15, 20);
        hashTable.insert(25, 30);
        hashTable.insert(7, 40);
        hashTable.insert(21, 43);
        hashTable.insert(11, 33);
        hashTable.insert(17, 50);

        for (int i = 0; i < tablesize; i++) {
            if (keys[i] != 0) {
                System.out.println("Key: " + keys[i] + ", Value: " + values[i]);
            }
        }
    }
}
