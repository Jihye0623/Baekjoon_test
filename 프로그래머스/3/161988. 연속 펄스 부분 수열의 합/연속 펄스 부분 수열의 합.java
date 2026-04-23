import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long maxPrefix = 0;
        long minPrefix = 0;
        long currentPrefix = 0;
        
        for(int i = 0; i<sequence.length; i++){
            int pulse = (i%2==0)? 1:-1;
            
            currentPrefix += (long) sequence[i] * pulse;
            
            maxPrefix = Math.max(maxPrefix, currentPrefix);
            minPrefix = Math.min(minPrefix, currentPrefix);
        }
        
        return maxPrefix - minPrefix;
    }
}