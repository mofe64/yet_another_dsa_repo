package javafiles;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] x = { 1, 12, -5, -6, 50, 3 };
        System.out.println(MaxAverageOfSubArray.naiveSolution(x, 4));
        System.out.println(MaxAverageOfSubArray.slidingWindowSolution(x, 4));
        x = new int[] { 0, 1, 1, 3, 3 };
        System.out.println(MaxAverageOfSubArray.naiveSolution(x, 4));
        System.out.println(MaxAverageOfSubArray.slidingWindowSolution(x, 4));

    }
}
