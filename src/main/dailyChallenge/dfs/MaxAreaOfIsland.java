package main.dailyChallenge.dfs;

import java.util.Stack;

public class MaxAreaOfIsland {
    int[][] grid;

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        int maxArea = new MaxAreaOfIsland().maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }

//    Recursive
//    public int maxAreaOfIsland(int[][] grid) {
//        this.grid = grid;
//        int max = 0;
//        for (int r = 0; r < grid.length; r++) {
//            for (int c = 0; c < grid[0].length; c++) {
//                max = Math.max(max, maxArea(r, c));
//            }
//        }
//        return max;
//    }
//
//    private int maxArea(int row, int col) {
//        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
//            return 0;
//        }
//        grid[row][col] = 0;
//        return 1 + maxArea(row - 1, col) + maxArea(row + 1, col) + maxArea(row, col - 1) + maxArea(row, col + 1);
//    }


    //    Iterative
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[] rowNav = {-1, 1, 0, 0};
        int[] colNav = {0, 0, -1, 1};

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int currMax = 0;
                    grid[r][c] = 0;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{r, c});

                    while (!stack.isEmpty()) {
                        int[] currCell = stack.pop();
                        currMax++;

                        int currRow = currCell[0];
                        int currCol = currCell[1];

                        for (int k = 0; k < 4; k++) {
                            int tempR = currRow + rowNav[k];
                            int tempC = currCol + colNav[k];

                            if (tempR >= 0 && tempR < grid.length
                                    && tempC >= 0 && tempC < grid[0].length
                                    && grid[tempR][tempC] == 1) {
                                stack.push(new int[]{tempR, tempC});
                                grid[tempR][tempC] = 0;
                            }
                        }
                    }
                    max = Math.max(max, currMax);
                }
            }
        }
        return max;
    }
}

