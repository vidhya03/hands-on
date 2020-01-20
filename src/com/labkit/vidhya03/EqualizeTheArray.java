package com.labkit.vidhya03;

import java.util.ArrayList;
import java.util.Arrays;

public class EqualizeTheArray {


    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {

        // get the maximum duplicates
        // if it is zero then length - 1,
        // else then remove one by one except maximum and return the count

        int maxDuplicates = 0, value = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>= 1 && arr[i] <= 100 ) {
                int currentDuplicates = getTheDuplicates(arr, arr[i]);
                if(currentDuplicates > maxDuplicates) {
                    maxDuplicates = currentDuplicates;
                    value = arr[i];
                }
                continue;
            }else {
                return 0;
            }
        }
        int removeCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != value){
                removeCount ++;
            }
        }
        return removeCount;
    }

   static int getTheDuplicates(int[] arr, int whichNo) {

        int count =0 ;

       for (int i = 0; i < arr.length; i++) {
           if(whichNo == arr[i]) {
               count++;
           }
       }
       return count;
    }



    public static void main(String[] args) {
        int[] question01 = {3, 3, 2, 1, 3};
        int answer01 = equalizeArray(question01);
        assert answer01 == 2 : "Expecting 2";

        int[] question02 = {1,102};
        int answero2 = equalizeArray(question02);
        assert answero2 == 0 : "Expecting 0";


        int[] question03 = {1, 2, 3,67};
        int answer03 = equalizeArray(question03);
        assert answer03 == 3 : "Expecting 1";


    }

}
