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

        int[][] grid = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] =0;
            }
        }
        fillObstacles(grid,obstacles, n);
        // Fill the queen

        r_q = (n-1) - (r_q -1);
        c_q = c_q -1;

        grid[r_q][c_q] = 'Q';

//        printGrid(grid,n);

        count += leftCount(grid, n,r_q ,c_q);
        count += rightCount(grid, n, r_q, c_q);
        count += upCount(grid, n, r_q, c_q);
        count += downCount(grid, n, r_q, c_q);

        count += leftUpCount(grid, n,r_q ,c_q);
        count += leftDownCount(grid, n,r_q ,c_q);
        count += rightUpCount(grid, n,r_q ,c_q);
        count += rightDownCount(grid, n,r_q ,c_q);




        return count;
    }

    private static int rightDownCount(int[][] grid, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q+1 < n && r_q+1 < n && grid[r_q+1][c_q+1]==0) {
            count++;
            c_q++;
            r_q++;
        }
        return count;
    }

    private static int leftDownCount(int[][] grid, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q-1 >=0 && r_q+1 < n && grid[r_q+1][c_q-1]==0) {
            count++;
            c_q--;
            r_q++;
        }
        return count;
    }

    private static int rightCount(int[][] grid, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q+1 < n && grid[r_q][c_q+1]==0) {
            count++;
            c_q++;
        }
        return count;
    }

    private static int rightUpCount(int[][] grid, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q+1 < n && r_q-1 >=0 && grid[r_q-1][c_q+1]==0) {
            count++;
            c_q++;
            r_q--;
        }
        return count;
    }

    private static int downCount(int[][] grid, int n, int r_q, int c_q) {
        int count =0 ;
        while(r_q+1 < n && grid[r_q+1][c_q]==0) {
            count++;
            r_q++;
        }
        return count;
    }

    private static int upCount(int[][] grid, int n, int r_q, int c_q) {
        int count =0 ;
        while(r_q-1 >= 0 && grid[r_q-1][c_q]==0) {
            count++;
            r_q--;
        }
        return count;
    }

    private static int leftCount(int[][] grid, int n, int r_q, int c_q) {
        int count =0 ;
        while(c_q-1 >=0 && grid[r_q][c_q-1]==0) {
            count++;
            c_q--;
        }
        return count;
    }

    private static int leftUpCount(int[][] grid, int n, int r_q, int c_q) {

        int count =0 ;
        while(c_q-1 >=0 && r_q-1 >=0 && grid[r_q-1][c_q-1]==0) {
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


    private static void fillObstacles(int[][] grid, int[][] obstacles, int n) {

        final int OBSTACLE = 1;

        for (int[] obstacle : obstacles) {
//            System.out.println("obstacle = " + obstacle);
            int row_x_i = obstacle[0];
            int col_y_j = obstacle[1];

            // Since the grid is computer defined array ,
            // Hence transform from bottom up to top down
            row_x_i = (n-1) - (row_x_i -1);
            col_y_j = col_y_j -1;

            grid[row_x_i][col_y_j] = OBSTACLE;
        }

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

        byte[][] grid = new byte [n][];
        for (int i = 0; i < n; i++) {
            grid[i] = new byte [n];
            for (int j = 0; j < n; j++) {
                grid[i][j] =0;
            }
        }

        int testcase3 = queensAttack(n, k, r_q, c_q, obstacles);

        assert testcase3 == 308369 : "Expecting 308369 but found " + testcase3;



    }

}
