package com.labkit.vidhya03;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int  jump = 0;

        if (2 <= c.length && c.length <= 100 && c[0] == 0 && c[c.length - 1] == 0) {
            int i = 0;
            while (i < c.length) {
                if (i + 2 < c.length && c[i + 2] == 0) {
                    jump += 1;
                    i+=2;
                } else {
                    if(i+1 < c.length ) {
                        jump += 1;
                    }
                    i++;
                }
            }
        }

        return jump;

    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0, 1, 0};
        int expected = jumpingOnClouds(a);
        assert expected == 3 : "Expecting 4 by found "+expected;

        int[] second = {0, 0, 1, 0, 0, 1, 0};
        int secondResult = jumpingOnClouds(second);
        assert secondResult == 4 : "Expecting 4 by found "+secondResult;

        int[] third = {0, 0, 0, 1, 0, 0};
        int thirdResult = jumpingOnClouds(third);
        assert thirdResult == 3 : "Expected 3 but found "+thirdResult;


    }
}
