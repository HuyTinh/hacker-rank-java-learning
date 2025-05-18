package big_number.primality_test;

import java.math.BigInteger;

public class JavaPrimalityTest_es {
    public static void main(String[] args) {
        String n = "2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373";

        boolean isPrime = (new BigInteger(n)).isProbablePrime(1);
        System.out.println(isPrime ? "prime" : "not prime");
    }
}
