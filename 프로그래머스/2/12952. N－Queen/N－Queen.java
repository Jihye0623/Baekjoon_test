import java.util.*;

class Solution {
    private static boolean[] width;
    private static boolean[] q1;
    private static boolean[] q2;
    private static int N, answer;
    private static int queen(int w){
        int ans = 0;
        if(w==N) ans++;
        else{
            for(int i = 0; i<N; i++){
                if(!width[i] && !q1[i+w] && !q2[i-w+N]){
                    width[i] = q1[i+w] = q2[i-w+N] = true;
                    ans += queen(w+1);
                    width[i] = q1[i+w] = q2[i-w+N] = false;
                }
            }
        }
        return ans;
    }
    
    public int solution(int n) {
        N = n;
        width = new boolean[n];
        q1 = new boolean[n*2];
        q2 = new boolean[n*2];
               
        answer = queen(0);
        
        return answer;
    }
}