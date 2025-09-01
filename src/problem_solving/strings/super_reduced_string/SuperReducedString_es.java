package problem_solving.strings.super_reduced_string;

import java.util.Scanner;

public class SuperReducedString_es {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scan.nextLine();

        String result = superReducedString(s);
        System.out.println(result);
    }

    public static String superReducedString(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            int length = stack.length();
            if (length > 0 && stack.charAt(length - 1) == c) {
                stack.deleteCharAt(length - 1);
            } else {
                stack.append(c);
            }
        }


        return stack.isEmpty() ? "Empty String" : stack.toString();
    }
}
