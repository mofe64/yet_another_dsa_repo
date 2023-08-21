package solutions

func LongestSubStringWithoutRepeatingCharacters(s string) int {
	windowStart := 0
	max := 0
	charMap := make(map[byte]bool)

	for windowEnd := range s {
		char := s[windowEnd]

		if !charMap[char] {
			charMap[char] = true
			windowCap := windowEnd - windowStart + 1
			if windowCap > max {
				max = windowCap
			}
		} else {
			// while loop (while charMap[char] == true)
			for charMap[char] {
				charMap[s[windowStart]] = false
				windowStart++
			}
			charMap[char] = true
		}
	}
	return max
}
