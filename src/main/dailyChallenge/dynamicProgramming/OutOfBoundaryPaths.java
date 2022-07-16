package main.dailyChallenge.dynamicProgramming;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    final int divider = 1000000007;
    final int[] rowNav = {-1,1,0,0};
    final int[] colNav = {0,0,-1,1};

    public static void main(String[] args) {
        System.out.println(new OutOfBoundaryPaths().findPaths(2,3,8,1,0));
    }

    //      Recursion
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        if (startRow < 0 || startRow == m || startColumn < 0 || startColumn == n) {
//            return 1;
//        }
//
//        if (maxMove == 0) {
//            return 0;
//        }
//
//        int left = findPaths(m, n, maxMove - 1, startRow, startColumn - 1);
//        int right = findPaths(m, n, maxMove - 1, startRow, startColumn + 1);
//        int top = findPaths(m, n, maxMove - 1, startRow - 1, startColumn);
//        int bottom = findPaths(m, n, maxMove - 1, startRow + 1, startColumn);
//
//        return left + right + top + bottom;
//    }


//    Memoization
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] grid = new int[m][n][maxMove + 1];
        for (int[][] matrix : grid) {
            for (int col[] : matrix) {
                Arrays.fill(col, -1);
            }
        }

        return findPathsUtil(m, n, maxMove, startRow, startColumn, grid);
    }

    private int findPathsUtil(int m, int n, int N, int i, int j, int[][][] grid) {
        if (i == m || i < 0 || j == n || j < 0) {
            return 1;
        }

        if (N == 0) {
            return 0;
        }

        if (grid[i][j][N] >= 0) {
            return grid[i][j][N];
        }

        int left = findPathsUtil(m, n, N - 1, i, j - 1, grid);
        int right = findPathsUtil(m, n, N - 1, i, j + 1, grid);
        int top = findPathsUtil(m, n, N - 1, i - 1, j, grid);
        int bottom = findPathsUtil(m, n, N - 1, i + 1, j, grid);

        grid[i][j][N] = ((left + right) % divider + (top + bottom) % divider) % divider;

        return grid[i][j][N];
    }
}
