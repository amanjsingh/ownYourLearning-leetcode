package main.dailyChallenge.array;

public class MaximumUnitsOnTruck {
    public static void main(String[] args) {
//        int[][] boxTypes = {{1,3},{2,2},{3,1}};
//        int truckSize = 4;

        int[][] boxTypes = {{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}};
        int truckSize = 35;

        System.out.println(new MaximumUnitsOnTruck().maximumUnits(boxTypes, truckSize));
    }

//    Counting Sort
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] boxSize = new int[1001];
        int countUnits = 0;
        for (int[] boxes : boxTypes) {
            boxSize[boxes[1]] += boxes[0];
        }

        for (int i = 1000; i >= 0 && truckSize > 0; i--) {
            if (boxSize[i] > 0) {
                if (boxSize[i] <= truckSize) {
                    countUnits += (boxSize[i] * i);
                    truckSize -= boxSize[i];
                } else {
                    countUnits += (truckSize * i);
                    truckSize = 0;
                }
            }
        }
        return countUnits;
    }
}