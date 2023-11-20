// Name: Carlos Macias
// Class: CS 4306/4
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ

/*
Test 1:

empirical-
26 comparisons
avg = 26 / 26 = 1

theoretical-
alpha = 26 / 26 = 1
avg = alpha = 1

The empirical and theoretical number of comparisons are the same, because
all the words for test 1 are distinct and have different starting letters meaning that
they are uniformly distributed with how hash indexes are obtained. They are also equal and
close to 1 because the number of inputted keys is equal to the size of the table (26).

Test 2:

empirical-
26 comparisons
avg = 26 / 26 = 1

theoretical-
alpha = 26 / 26 = 1
avg = alpha = 1

The empirical and theoretical average number of comparisons are the same, this is because
there is only one word which maps to the same index everytime so for every key inputted,
only one probe is needed.

Test 3:

empirical-
326 comparisons
avg = 351 / 26 = 13.5

theoretical-
alpha = 26 / 26 = 1
avg = alpha = 1

The empirical and theoretical average number of comparisons differ by a large amount, this
is because the theoretical number assumes that keys are distributed uniformly. In this particular test
case, the keys are all getting mapped to the same index since they start with the same letter. However, they are
all distinct words so every subsequent word requires one more comparison than the previous required number of
comparisons.

Test 4:

empirical-
53 comparisons
avg = 53 / 26 = 2

theoretical-
alpha = 26 / 26 = 1
avg = alpha = 1

The empirical and theoretical average number of comparisons differ by about 1 comparisons,
this difference can be explained by the repeats in starting letters since this will cause
collisions for some words. Since this test case has randomly generated words, the keys are still
relatively uniformly distributed so the difference in empirical and theoretical averages are not too different.

Test 5:

empirical-
1828 comparisons
avg = 1828 / 352 = 5.2

theoretical-
alpha = 352 / 26 = 13.5
successful avg = 1 + 13.5 / 2 = 7.75
unsuccessful avg = 13.5

The empirical average comparisons is lower that the theoretical average comparisons by about 2 in the case of
successful avg (not all words are distinct in this case). This could be explained by certain words that
are used often such as "and", "a", "it", etc. This could decrease the expected comparisons because they are
found relatively quickly compared to completely new and random words which would decrease the comparison average.


 */

import java.util.*;


public class Main {

    public static int comparisons = 0;

    public static void main(String[] args) {

        // Declare user input, text input, and hash table variables
        int select = 0;
        ArrayList<String> inputText = new ArrayList<String>();
        hashTable hashWords = new hashTable();

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n---------------MAIN MENU---------------\n" +
                    "1. Read input text\n" +
                    "2. Hash Input Text to Hash Table\n" +
                    "3. Display Words and Occurrences\n" +
                    "4. Display Efficiency Outputs\n" +
                    "5. Exit program\n" +
                    " Enter option number:");

            select = input.nextInt();
            input.nextLine();

            // Take and process input text
            if (select == 1) {

                System.out.print("Input: ");
                String words = input.nextLine();

                // After reading text as one string, remove punctuation and separate words into array
                String[] delimitWords = words.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s");

                // Convert to array list in order to simplify removing invalid input
                List<String> wordsList = Arrays.asList(delimitWords);
                inputText = new ArrayList<String>(wordsList);

                // Redeclare comparisons and hash table for new inputs
                hashWords = new hashTable();
                comparisons = 0;


                // Remove words that don't have a proper key as input (non-lowercase first letter)
                for (int i = 0; i < inputText.size(); i++) {

                    if (inputText.get(i).length() < 1) {
                        inputText.remove(i);
                    }


                    int ascii = inputText.get(i).charAt(0);

                    // remove if not between a-b
                    if (ascii < 97 || ascii > 122) {
                        inputText.remove(inputText.get(i));
                    }


                }






            }
            else if (select == 2) {

                // Populate hash table with input text
                for (String word: inputText) {
                    hashWords.insert(word);
                }


            }
            else if (select == 3) {

                System.out.println("Key Word    Word Count\n" +
                        "-----------------------");

                // Traverse hash table
                for (int i = 0; i < hashWords.table.length; i++) {
                    hashNode curr = hashWords.table[i];

                    // Traverse linked list of hash nodes for each index
                    while (curr.next != null) {

                        // format key word and value for word
                        if (curr.getKeyWord() != null) {
                            System.out.printf("%-15s", curr.getKeyWord());
                            System.out.printf("%-5d\n",  curr.getValueCount());
                        }
                        curr = curr.next;
                    }

                    // Print out last node info
                    if (curr.getKeyWord() != null) {
                        System.out.printf("%-15s", curr.getKeyWord());
                        System.out.printf("%-5d\n",  curr.getValueCount());
                    }
                }
            }
            else if (select == 4) {

                // Print efficiency outputs
                System.out.println("Input values: " + inputText +
                        "\nInputs size: " + inputText.size() +
                        "\nNumber of comparisons: " + comparisons);
            }



        } while (select != 5);

    }
}
