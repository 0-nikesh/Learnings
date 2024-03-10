class LP{
    static final int  tablesize=10; //size of the table
    static int [] keys; //array to store the keys
    static int [] values; //array to store the values
    static int  size; // Number of elements currently stored in the hash table

    public LP(){
        keys = new int[tablesize]; 
        values = new int[tablesize];
        size = 0;
    }
    // Hash function to compute the i for a key
   static int hash(int key){
        return key % tablesize;
    }

    // Insertion operation using linear probing
    void insert(int key, int value ){
        int i = hash(key);

        // Linearly search for the next available slot
        while ((keys[i]!=0) && (keys[i]!=key) ){
            i= (i+1)%tablesize;
        }
        
        // If an empty slot is found, insert the key-value pair
        if(keys[i]==0){
            keys[i] = key;
            values[i] = value;
            size++;
        }else{
            values[i]= value;
        }

    }

    public static void main(String[] args) {
        LP hashTable = new LP();
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

//time complexity = O(n)  O(1)in best case 
///hashing is a technique to store the data of arbitarray size to fixedsized values. ITs purpose it to quickly locate the data given its search key. 

//hash table is a data structure which maps key to values. It uses hash function to compute on index into an array of slot from which desired value can be found.

//linear probing is a technique to solve collision in close addressing hash tables.
// In linear probing, if a collision occures at a specidic index the algorithm searches linearly for the next avariable slot in te array until it find it.