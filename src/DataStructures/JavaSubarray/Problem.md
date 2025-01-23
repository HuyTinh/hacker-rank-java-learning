

We define the following:

*   A _subarray_ of an \-element array is an array composed from a contiguous block of the original array's elements. For example, if , then the subarrays are , , , , , and . Something like would _not_ be a subarray as it's not a contiguous subsection of the original array.
*   The _sum_ of an array is the total sum of its elements.
    *   An array's sum is _negative_ if the total sum of its elements is negative.
    *   An array's sum is _positive_ if the total sum of its elements is positive.

Given an array of integers, find and print its number of _negative subarrays_ on a new line.

**Input Format**



The first line contains a single integer, , denoting the length of array .  
The second line contains space-separated integers describing each respective element, , in array .

**Constraints**



**Output Format**



Print the number of subarrays of having negative sums.

**Sample Input**



    5
    1 -2 4 -5 1


**Sample Output**



    9


**Explanation**



There are nine negative subarrays of :

Thus, we print on a new line.