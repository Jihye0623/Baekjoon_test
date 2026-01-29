import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n+2];
        Arrays.fill(people, 1);
        for(int l:lost){
            people[l]--;
        }
        for(int r:reserve){
            people[r]++;
        }
        
        for(int i= 1; i<=n; i++){
            if(people[i] == 0){
                if(people[i-1]==2){
                    people[i]++;
                    people[i-1]--;
                }
                else if(people[i+1]==2){
                    people[i]++;
                    people[i+1]--;
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(people[i]>=1) answer++;
        }
        return answer;
    }
}