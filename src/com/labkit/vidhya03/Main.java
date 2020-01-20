package com.labkit.vidhya03;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] x = {10, 10, 30, 20, 40, 20, 50, 30,50};
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        int sum = 0;

        for (int i = 0; i < x.length; i++) {
            int count = totalNumberOf(x, x[i]);
            boolean hasAdded = hashSet.add(x[i]);
            if(hasAdded) {
                sum += count;
            }
        }

        System.out.println("sum = " + sum);

    }


    public static int totalNumberOf(int[] x, int key) {

        int  count = 0;


        for (int i = 0; i < x.length; i++) {

            if (x[i] == key) {
                count++;
            }
        }
        System.out.println("Key " + key + " count = " + count);

        return count / 2;

    }

}
