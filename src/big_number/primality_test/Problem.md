

A prime number is a natural number greater than whose only positive divisors are and itself. For example, the first six prime numbers are , , , , , and .

Given a large integer, , use the Java _BigInteger_ class' [_isProbablePrime_](https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#isProbablePrime%28int%29) method to determine and print whether it's `prime` or `not prime`.

**Input Format**



A single line containing an integer, (the number to be checked).

**Constraints**

*   contains at most digits.

**Output Format**



If is a prime number, print `prime`; otherwise, print `not prime`.

**Sample Input**



```
13
```

**Sample Output**



```
prime
```

**Explanation**



The only positive divisors of are and , so we print `prime`.