// Name: Carlos Macias
// Class: CS 4306/4
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ


import java.util.Objects;

public class hashTable {
    hashNode[] table;

    public hashTable() {

        // Declare hashtable as a table of hash nodes, size of alphabet
        table = new hashNode[26];

        // Populate hash table with null valued nodes
        for (int i = 0; i < table.length; i++) {
            table[i] = new hashNode();
        }
    }

    // Obtain index of key
    public int hash(String word) {

        // Compute index of key based on its ascii value
        int ascii = word.charAt(0);
        return (ascii % 97);

    }

    // Insert new key
    public void insert(String word) {
        int index = hash(word);

        // keep track of most recent and previous hash nodes in index chain
        hashNode current = table[index];
        hashNode prev = current;

        boolean found = false;

        // Traverse through linked list at index of hashed key to find match
        while (current != null && current.getKeyWord() != null) {

            Main.comparisons++;
            // Found key means no need for insertion so just increment number of occurences
            if (Objects.equals(current.getKeyWord(), word)) {
                found = true;
                current.incrementValueCount();
                break;
            }

            prev = current;
            current = current.next;

        }


        // Brand new key so insert into table
        if (!found) {

            Main.comparisons++;
            if (prev.getKeyWord() == null) {
                prev.keyWord = word;
                prev.valueCount = 1;
            } else {
                prev.next = new hashNode(word);
            }
        }
    }

}
