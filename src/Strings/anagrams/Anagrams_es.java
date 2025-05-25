package Strings.anagrams;

import java.util.*;

public class Anagrams_es {
    public static boolean isAnagrams(String str1, String str2) {
        String finalStr1 = str1.toLowerCase();
        String finalStr2 = str2.toLowerCase();

        String combined = finalStr1 + finalStr2;
        Set<Character> characterSet = new HashSet<>();

        for (char c : combined.toCharArray()) {
            characterSet.add(c);
        }

        for (char c : characterSet) {
            long freStr1 = finalStr1.chars().filter(value -> value == c).count();
            long freStr2 = finalStr2.chars().filter(value -> value == c).count();

            if (freStr1 != freStr2) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int index = 0;
        String[] args_v1 = new String[2];
        while(scanner.hasNext()) {
            args_v1[index++] = scanner.nextLine();
        }

        boolean isAnagrams = isAnagrams(args_v1[0], args_v1[1]);

        if (isAnagrams)
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");

        scanner.close();
    }
}
