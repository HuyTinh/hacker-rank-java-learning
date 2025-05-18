package data_structures.java_2d_array;

import java.util.ArrayList;
import java.util.List;

public class Java2DArray_es {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.size() - 2; i++) {
            for(int j = 0; j < arr.get(i).size() - 2; j ++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i+1).get(j+1)
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                maxSum = Math.max(sum, maxSum);

            }
        }

        System.out.println(maxSum);
    }
}
