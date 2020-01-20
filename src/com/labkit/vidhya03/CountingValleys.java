package com.labkit.vidhya03;

import java.util.ArrayList;

public class CountingValleys {

    public static final int  countingValleys(int n, String s) {

        int min = 2;
        int max = 1000000;
        int valleyCount =0;


        if(min <= n && n <= max && s.length() == n ) {

            ArrayList<Integer> convertion = new ArrayList<>(n);

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
              int  current =  (c == 'U'  ) ? 1 : -1;
                convertion.add(current);
            }

            int path = 0; boolean isInValley  = false;
            for (int cur: convertion) {

                path += cur;
                if(path == 0 && isInValley) {
                    valleyCount ++;
                    isInValley = false;
                }
                if (path < 0 && !isInValley) {
                    isInValley = true;
                }
            }

            return  valleyCount;



        } else  {
            return  valleyCount;
        }


    }


    public static void main(String[] args) {
        int ud_10 = countingValleys(10, "UDDDUDUUDU");
        assert  ud_10 == 2 : "Expecting 2";
        int ud_1 = countingValleys(8, "UDDDUDUU");
        assert  ud_1 == 1: "Expecting 1";


        int ud_null = countingValleys(8, "UDDDUDU");
        assert  ud_null == 0: "Expecting 0";

        System.out.println("ud_1 = " + ud_1);

    }
}
