package data_structures.array_list;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayList_es {

    private static List<Integer> strToIntArr(String str) {
        return Arrays.stream(str.split(" "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        List<List<Integer>> values = new ArrayList<>();

        int loopIndex = 0;
        String errorMessage = "ERROR!";
        int valuesIndex = Integer.parseInt(sc.nextLine());
        int queriesIndex = valuesIndex + 1;

        while(sc.hasNext()) {
            String str = sc.nextLine();

            if (loopIndex < valuesIndex) {
                values.add(strToIntArr(str));
            } else if (loopIndex >= queriesIndex) {
                List<Integer> queries = strToIntArr(str);

                int valsIndex = queries.get(0) - 1;
                int insertValsIndex = queries.get(1);

                List<Integer> insertVals = values.get(valsIndex);

                if (Objects.isNull(insertVals) || insertVals.isEmpty()) {
                    System.out.println(errorMessage);
                } else if (insertValsIndex >= insertVals.size() || Objects.isNull(insertVals.get(insertValsIndex))) {
                    System.out.println(errorMessage);
                } else {
                    System.out.println(insertVals.get(insertValsIndex));
                }
            }

            loopIndex++;
        }
    }
}
