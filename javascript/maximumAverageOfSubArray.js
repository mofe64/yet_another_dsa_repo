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
