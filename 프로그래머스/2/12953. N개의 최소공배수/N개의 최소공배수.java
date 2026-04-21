import java.util.*;

class Solution {
    private static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
    
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i<arr.length; i++){
            int g = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / g;
        }
        
        return answer;
        
    }
}