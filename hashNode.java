// Name: Carlos Macias
// Class: CS 4306/4
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ


public class hashNode {
    String keyWord;
    int valueCount;
    hashNode next;

    // Each hash node requires a key (word), value (occurences of word), and pointer to next hash node in the index
    hashNode(String key) {
        keyWord = key;
        valueCount = 1;
        next = null;
    }

    // Empty hashnode
    hashNode() {
        keyWord = null;
        next = null;
    }

    // Return key word
    public String getKeyWord() {
        return keyWord;
    }

    // Return occurences of key
    public int getValueCount() {
        return valueCount;
    }

    public void incrementValueCount() {
        valueCount++;
    }
}
