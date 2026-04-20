import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int start = 0, end = B.length-1;
        int answer = 0;
        
        for(int i = 0; i<A.length; i++){
            answer += A[start] * B[end];
            start++;
            end--;
        }

        return answer;
    }
}