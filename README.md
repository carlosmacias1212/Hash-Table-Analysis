# Hash-Table-Analysis
Implemented hash table data structure and provided empirical and theoretical analysis of its performance

## Test 1:

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

## Test 2:

empirical-
26 comparisons
avg = 26 / 26 = 1

theoretical-
alpha = 26 / 26 = 1
avg = alpha = 1

The empirical and theoretical average number of comparisons are the same, this is because
there is only one word which maps to the same index everytime so for every key inputted,
only one probe is needed.

## Test 3:

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

## Test 4:

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

## Test 5:

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


