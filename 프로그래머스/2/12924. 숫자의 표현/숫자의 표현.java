import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 0, end = 0;
        int sum = 0;
        
        while(end<=n){
            if(sum<n){
                end++;
                sum += end;
            }
            else if(sum>n){
                start++;
                sum-=start;
            }
            else{
                answer++;
                end++;
                sum += end;
            }
        }
        
        return answer;
    }
}