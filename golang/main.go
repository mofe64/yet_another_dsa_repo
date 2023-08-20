package main

import (
	"fmt"
	"mofe64/dsa/solutions"
)

func main() {
	fmt.Println("hello world")
	nums := []int{1, 12, -5, -6, 50, 3}
	max := solutions.MaxAvgOfSubArraySlidingWindowSolution(nums, 4)
	fmt.Println(max)
	nums = []int{0, 1, 1, 3, 3}
	max = solutions.MaxAvgOfSubArraySlidingWindowSolution(nums, 4)
	fmt.Println(max)

}
