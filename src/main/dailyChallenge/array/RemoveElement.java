package main.dailyChallenge.array;

public class RemoveElement {
    public static void main(String[] args) {
//        int[] nums = {3,2,2,3};
//        int val = 3;

        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

//        int[] nums = {1};
//        int val = 1;

        int newArrayLen = removeElement(nums, val);
        for(int i=0; i<newArrayLen; i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int index=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
    }
}
