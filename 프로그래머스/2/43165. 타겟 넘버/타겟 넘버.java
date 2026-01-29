import java.util.*;

class Solution {
    private static int T;
    private static int dfs(int[] nums, int idx, int sum){
        if(idx == nums.length){
            if(sum==T) return 1;
            return 0;
        }
        
        return dfs(nums, idx+1, sum+nums[idx]) + dfs(nums, idx+1, sum-nums[idx]);
    }
    public int solution(int[] numbers, int target) {
        T = target;
        return dfs(numbers, 0,0);
    }
}