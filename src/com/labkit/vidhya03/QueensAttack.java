package com.labkit.vidhya03;

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


       // Fill the queen

        r_q = (n-1) - (r_q -1);
        c_q = c_q -1;


//        printGrid(grid,n);

        count += leftCount(obstacles, n,r_q ,c_q);
        count += rightCount(obstacles, n, r_q, c_q);
        count += upCount(obstacles, n, r_q, c_q);
        count += downCount(obstacles, n, r_q, c_q);

        count += leftUpCount(obstacles, n,r_q ,c_q);
        count += leftDownCount(obstacles, n,r_q ,c_q);
        count += rightUpCount(obstacles, n,r_q ,c_q);
        count += rightDownCount(obstacles, n,r_q ,c_q);




        return count;
    }

    private static int rightDownCount(int[][] obstacles, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q+1 < n && r_q+1 < n && !isObstacles(obstacles, n, r_q+1, c_q+1)) {
            count++;
            c_q++;
            r_q++;
        }
        return count;
    }

    private static int leftDownCount(int[][] obstacles, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q-1 >=0 && r_q+1 < n && !isObstacles(obstacles, n, r_q+1, c_q-1)) {
            count++;
            c_q--;
            r_q++;
        }
        return count;
    }

    private static int rightCount(int[][] obstacles, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q+1 < n && !isObstacles(obstacles, n, r_q, c_q+1)) {
            count++;
            c_q++;
        }
        return count;
    }

    private static int rightUpCount(int[][] obstacles, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q+1 < n && r_q-1 >=0 && !isObstacles(obstacles, n, r_q-1, c_q+1)) {
            count++;
            c_q++;
            r_q--;
        }
        return count;
    }

    private static int downCount(int[][] obstacles, int n, int r_q, int c_q) {
        int count =0 ;
        while(r_q+1 < n && !isObstacles(obstacles, n, r_q+1, c_q)) {
            count++;
            r_q++;
        }
        return count;
    }

    private static int upCount(int[][] obstacles, int n, int r_q, int c_q) {
        int count =0 ;
        while(r_q-1 >= 0 && !isObstacles(obstacles, n, r_q-1, c_q)) {
            count++;
            r_q--;
        }
        return count;
    }

    private static int leftCount(int[][] obstacles, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q-1 >=0 &&  !isObstacles(obstacles, n, r_q, c_q-1)) {
            count++;
            c_q--;
        }
        return count;
    }

    private static int leftUpCount(int[][] obstacles, int n, int r_q, int c_q) {

        int count =0 ;
        while(c_q-1 >=0 && r_q-1 >=0 && !isObstacles(obstacles, n, r_q-1, c_q-1)) {
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
        n = 5;
        k = 3;
        r_q = 4;
        c_q = 3;
//        obstacles = new int[k][2];

        int[][] obstacles = {{5, 5}, {4, 2}, {2, 3}};
        int firstTest = queensAttack(n, k, r_q, c_q, obstacles);

        assert firstTest == 10 : "Expecting 10 but found " + firstTest;


        n = 100000 ;
        k =0 ;
        r_q = 4187;
        c_q = 5068;

        int testcase3 = queensAttack(n, k, r_q, c_q, obstacles);

        assert testcase3 == 308369 : "Expecting 308369 but found " + testcase3;



    }

}
