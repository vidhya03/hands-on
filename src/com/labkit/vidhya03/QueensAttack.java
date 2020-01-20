package com.labkit.vidhya03;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.LinkedHashMap;

public class QueensAttack {


    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {


        int count = 0;
        // check the constraints

        if (!(n >0 && n <= (int)Math.pow(10, 5))) {
            return count;
        }

        if (!((0 <= k && k <= (int)Math.pow(10, 5)))) {
            return count;
        }

        LinkedHashMap<String, String> linkedHashMap = convertObstacles(obstacles, n);


        // Fill the queen

        r_q = (n-1) - (r_q -1);
        c_q = c_q -1;


//        printGrid(grid,n);

        count += leftCount(linkedHashMap, n,r_q ,c_q);
        count += rightCount(linkedHashMap, n, r_q, c_q);
        count += upCount(linkedHashMap, n, r_q, c_q);
        count += downCount(linkedHashMap, n, r_q, c_q);

        count += leftUpCount(linkedHashMap, n,r_q ,c_q);
        count += leftDownCount(linkedHashMap, n,r_q ,c_q);
        count += rightUpCount(linkedHashMap, n,r_q ,c_q);
        count += rightDownCount(linkedHashMap, n,r_q ,c_q);




        return count;
    }

    private static String concatRowCol(int row, int col){
        return "" + row + "" + col;
    }
    private static LinkedHashMap<String, String> convertObstacles(int[][] obstacles,int n) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        for (int[] obstacle : obstacles) {
            int row_x_i = obstacle[0];
            int col_y_j = obstacle[1];
            // Since the grid is computer defined array ,
            // Hence transform from bottom up to top down
            row_x_i = (n-1) - (row_x_i -1);
            col_y_j = col_y_j -1;

            linkedHashMap.put(concatRowCol(row_x_i , col_y_j),concatRowCol(row_x_i , col_y_j) );
        }
        return linkedHashMap;
    }

    private static int rightDownCount(LinkedHashMap<String, String> linkedHashMap, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q+1 < n && r_q+1 < n && !linkedHashMap.containsValue(concatRowCol(r_q+1, c_q+1))) {
            count++;
            c_q++;
            r_q++;
        }
        return count;
    }

    private static int leftDownCount(LinkedHashMap<String, String> linkedHashMap, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q-1 >=0 && r_q+1 < n && !linkedHashMap.containsValue(concatRowCol(r_q+1, c_q-1))) {
            count++;
            c_q--;
            r_q++;
        }
        return count;
    }

    private static int rightCount(LinkedHashMap<String, String> linkedHashMap, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q+1 < n && !linkedHashMap.containsValue(concatRowCol(r_q, c_q+1))) {
            count++;
            c_q++;
        }
        return count;
    }

    private static int rightUpCount(LinkedHashMap<String, String> linkedHashMap, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q+1 < n && r_q-1 >=0 && !linkedHashMap.containsValue(concatRowCol(r_q-1, c_q+1))) {
            count++;
            c_q++;
            r_q--;
        }
        return count;
    }

    private static int downCount(LinkedHashMap<String, String> linkedHashMap, int n, int r_q, int c_q) {
        int count =0 ;
        while(r_q+1 < n && !linkedHashMap.containsValue(concatRowCol(r_q+1, c_q))) {
            count++;
            r_q++;
        }
        return count;
    }

    private static int upCount(LinkedHashMap<String, String> linkedHashMap, int n, int r_q, int c_q) {
        int count =0 ;
        while(r_q-1 >= 0 && !linkedHashMap.containsValue(concatRowCol(r_q-1, c_q))) {
            count++;
            r_q--;
        }
        return count;
    }

    private static int leftCount(LinkedHashMap<String, String> linkedHashMap, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q-1 >=0 &&  !linkedHashMap.containsValue(concatRowCol(r_q, c_q-1))) {
            count++;
            c_q--;
        }
        return count;
    }

    private static int leftUpCount(LinkedHashMap<String, String> linkedHashMap, int n, int r_q, int c_q) {

        int count =0 ;
        while(c_q-1 >=0 && r_q-1 >=0 && !linkedHashMap.containsValue(concatRowCol(r_q-1, c_q-1))) {
            count++;
            c_q--;
            r_q--;
        }
        return count;

    }

    private static void printGrid(int[][] grid, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("["+i+"]["+j+"] = " + grid[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }

    }


    private static boolean isObstacles(int[][] obstacles, int n, int r_q, int c_q) {

        for (int[] obstacle : obstacles) {
            int row_x_i = obstacle[0];
            int col_y_j = obstacle[1];
            // Since the grid is computer defined array ,
            // Hence transform from bottom up to top down
            row_x_i = (n-1) - (row_x_i -1);
            col_y_j = col_y_j -1;

            if(row_x_i == r_q && col_y_j == c_q) {
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {


        int n;
        int k;
        int r_q;
        int c_q;


        ///////////////
        // First input
//        n = 5;
//        k = 3;
//        r_q = 4;
//        c_q = 3;
//
//
//        int[][] obstacles = {{5, 5}, {4, 2}, {2, 3}};
//        int firstTest = queensAttack(n, k, r_q, c_q, obstacles);
//
//        assert firstTest == 10 : "Expecting 10 but found " + firstTest;
//
//
//        n = 100000 ;
//        k =0 ;
//        r_q = 4187;
//        c_q = 5068;
//
//        int testcase3 = queensAttack(n, k, r_q, c_q, obstacles);
//
//        assert testcase3 == 308369 : "Expecting 308369 but found " + testcase3;
//
//
        n = 100000;
        k = 100000;
        r_q = 4697;
        c_q = 4728;
        int[][] obstacles2 = new int[k][2];

        try {
            List<String> allLines = Files.readAllLines(Paths.get("X:\\opensource12\\vidhya-handson\\src\\com\\labkit\\vidhya03\\QueensAttack-array-input.txt"), Charset.defaultCharset());
            int i= 0;
            for (String line : allLines) {
                String[] obstaclesRowItems = line.split(" ");
                for (int j = 0; j < 2; j++) {
                    int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                    obstacles2[i][j] = obstaclesItem;
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("obstacles2 = " + obstacles2);
//        printObstaclesGrid(obstacles2, k);

//
        long start = System.currentTimeMillis();
        int testcase03 = queensAttack(n, k, r_q, c_q, obstacles2);

        assert testcase03 == 30544 : "Expecting 30544 but found "+testcase03;
        long end = System.currentTimeMillis();
        // Took 2312 - 2683 milliseconds
        System.out.println("Took  = " + (end - start));




    }

    private static void printObstaclesGrid(int[][] obstacles2,int k) {
        for (int i = 0; i < k; i++) {


            for (int j = 0; j < 2; j++) {
                System.out.println("obstacles2 = " + obstacles2[i][j]);
            }
        }
    }

}
