package main.dailyChallenge.dynamicProgramming;

public class MinCostStairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int itr = 2;
        while(itr<len){
            cost[itr] = cost[itr] + Math.min(cost[itr-1],cost[itr-2]);
            itr++;
        }

        return Math.min(cost[len-1],cost[len-2]);
    }
}
