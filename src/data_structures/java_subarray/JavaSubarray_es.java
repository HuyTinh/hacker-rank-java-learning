package data_structures.java_subarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaSubarray_es {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> strArr = new ArrayList<>();
        while(scan.hasNext()) {
            scan.nextLine();
            String strLine = scan.nextLine();

            strArr.addAll(Arrays.asList(strLine.split(" ")));
        }
        int count = 0;
        for(int i = 0; i < strArr.size(); i++) {
            for(int j = i + 1; j < strArr.size() + 1; j++) {
                // System.out.println("i = "+i+", j = "+j+" "+strArr.subList(i, j).stream().map(Integer::parseInt).reduce((t, u) -> t+u).get());
                if(strArr.subList(i, j).stream().map(Integer::parseInt).reduce((t, u) -> t+u).get() < 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
