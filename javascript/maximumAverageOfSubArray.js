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

const naiveSolution = (nums, k) => {
  if (nums.length === 1) {
    return nums[0] / 1;
  }

  let maxAverage = Number.NEGATIVE_INFINITY;
  for (let i = 0; i < nums.length; i++) {
    let subArraySum = 0;
    for (let j = 0; j < k; j++) {
      const lastIndexInSubArray = i + k - 1;
      const subArrayMemberIndex = i + j;
      if (lastIndexInSubArray <= nums.length - 1) {
        const subArrayMember = nums[subArrayMemberIndex];
        subArraySum += subArrayMember;
      }
    }

    if (subArraySum != 0) {
      const subArrayAverage = subArraySum / k;
      if (subArrayAverage > maxAverage) {
        maxAverage = subArrayAverage;
      }
    }
  }
  return maxAverage;
};

const slidingWindowSolution = (nums, k) => {
  let max = Number.NEGATIVE_INFINITY;
  let windowStartIndex = 0;
  let windowEndIndex = 0;
  let windowSum = 0;
  const maxWindowCapacity = k - 1;

  while (windowEndIndex < nums.length) {
    windowSum += nums[windowEndIndex];
    const windowCurrentCapacity = windowEndIndex - windowStartIndex;
    if (windowCurrentCapacity === maxWindowCapacity) {
      const windowAverage = windowSum / k;
      if (windowAverage > max) {
        max = windowAverage;
      }
      windowSum -= nums[windowStartIndex];
      windowStartIndex++;
    }

    windowEndIndex++;
  }
  return max;
};

console.log(
  naiveSolution([1, 12, -5, -6, 50, 3], 4),
  slidingWindowSolution([1, 12, -5, -6, 50, 3], 4)
);
console.log(naiveSolution([0], 1), slidingWindowSolution([0], 1));
