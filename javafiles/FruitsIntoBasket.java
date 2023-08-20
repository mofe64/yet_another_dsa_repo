package javafiles;

import java.util.HashMap;
import java.util.Map;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from
 * left to right. The trees are represented by an integer array fruits where
 * fruits[i] is the type of fruit the ith tree produces.
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked
 * fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 * Given the integer array fruits, return the maximum number of fruits you can
 * pick.
 * 
 * Example 1:
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * 
 * Example 2:
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * 
 * Example 3:
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 */

public class FruitsIntoBasket {
    public static int slidingWindowSolution(int[] trees) {
        Map<Integer, Boolean> baskets = new HashMap<>();
        int windowStart = 0;
        int windowEnd = 0;
        int max = 0;

        for (; windowEnd < trees.length; windowEnd++) {
            int currentTree = trees[windowEnd];
            if (baskets.size() < 2 && baskets.get(currentTree) == null) {
                baskets.put(currentTree, true);
                int windowCapacity = windowEnd - windowStart + 1;
                if (max < windowCapacity) {
                    max = windowCapacity;
                }
            } else if (baskets.get(currentTree) != null && baskets.get(currentTree)) {
                int windowCapacity = windowEnd - windowStart + 1;
                if (max < windowCapacity) {
                    max = windowCapacity;
                }
            } else {
                baskets = new HashMap<>();
                baskets.put(currentTree, true);
                baskets.put(trees[windowEnd - 1], true);
                // reposition window start to just before window end
                windowStart = windowEnd - 1;

                // extend window start to include previous fruits of same type
                while (trees[windowStart] == trees[windowStart - 1]) {
                    windowStart--;
                }
            }

        }
        return max;
    }
}
