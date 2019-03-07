package com.mana.solutions.findTopK;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/description/

public class CountSubarrayWithSumK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // Sum vs count
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

/*Another approach would have been to keep presum array and then for each window length keep checking if
* sum id K or not....this is O(n^2)
* sum[i...j] = sum[j] - sum[i]
*
* But think like this we don't need tp check all combinations of i that give sum diff = K
* instead keep a maps as you move along....doing in this way gives O(n) complexity and we directly
* compute the resulting count
* */