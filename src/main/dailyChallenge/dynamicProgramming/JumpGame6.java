package main.dailyChallenge.dynamicProgramming;

import java.util.ArrayDeque;
import java.util.Deque;

// Jump Game 6
public class JumpGame6 {
    public static void main(String[] args) {
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;

        System.out.println(maxResult(nums, k));
    }

    public static int maxResult(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int i=nums.length-1;
        deque.add(i);

        for(i=i-1; i>=0; i--){
            if(deque.getFirst()-i > k){
                deque.removeFirst();
            }
            nums[i] = nums[i]+nums[deque.getFirst()];
            while(deque.size()>0 && nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        return nums[0];
    }

}
