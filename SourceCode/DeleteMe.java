package SourceCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeleteMe {

     public static void main(String[] args) {
          List<Integer> listOfValues = createList();

          //     System.out.println(listOfValues);

          System.out.println(listOfValues.size());

          HashMap<Integer, Integer> frequencyMap = new HashMap<>();

          for (Integer elem : listOfValues) {
               if (!frequencyMap.containsKey(elem)) {
                    frequencyMap.put(elem, 1);
               } else {
                    frequencyMap.put(elem, frequencyMap.get(elem) + 1);
               }
          }

          System.out.println(frequencyMap);
     }

     private static List<Integer> createList() {
          int[] spinner1Vals = new int[]{1, 2, 3, 4, 5};
          int[] spinner2Vals = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
          int[] spinner3Vals = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
          int[] spinner4Vals = new int[]{1, 2, 3, 4, 5, 6};


          List<Integer> listOfValues = new ArrayList<>();
          for (int spinner1Val : spinner1Vals) {
               for (int spinner2Val : spinner2Vals) {
                    for (int spinner3Val : spinner3Vals) {
                         for (int spinner4Val : spinner4Vals) {
                              listOfValues.add(spinner1Val + spinner2Val + spinner3Val + spinner4Val);
                         }
                    }
               }
          }
          return listOfValues;
     }

}
