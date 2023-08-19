package javafiles;

/**
 * 
 * You are given an integer array nums consisting of n elements, and an integer
 * k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less
 * than 10-5 will be accepted.
 * 
 * Example 1:
 * 
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 * 
 * Input: nums = [5], k = 1
 * Output: 5.00000
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 10
 * 
 */

public class MaxAverageOfSubArray {
    public static double naiveSolution(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] / k;
        }

        double maxAverage = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < nums.length; i++) {
            double subArraySum = 0;
            int subArrayMaxIndex = i + (k - 1);
            for (int j = 0; j < k; j++) {
                if (subArrayMaxIndex <= nums.length - 1) {
                    int subarrayMember = nums[i + j];
                    subArraySum += subarrayMember;
                }
            }
            if (subArraySum != 0) {
                double subArrayAverage = subArraySum / k;
                if (subArrayAverage > maxAverage) {
                    maxAverage = subArrayAverage;
                }
            }
        }
        return maxAverage;
    }

    public static double slidingWindowSolution(int[] nums, int k) {
        double windowSum = 0;
        int windowStart = 0;
        int windowEnd = 0;
        double maxAverage = Double.NEGATIVE_INFINITY;

        while (windowEnd < nums.length) {
            windowSum = windowSum + nums[windowEnd];

            if (windowEnd - windowStart == k - 1) {
                double windowAvg = windowSum / k;
                if (windowAvg > maxAverage) {
                    maxAverage = windowAvg;
                }
                windowSum = windowSum - nums[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        return maxAverage;
    }
}