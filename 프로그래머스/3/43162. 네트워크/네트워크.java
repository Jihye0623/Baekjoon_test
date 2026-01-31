import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int[][] Com;
    private static int N;
    
    private static void dfs(int now){
        visited[now] = true;
        for(int i = 0; i<N; i++){
            if(visited[i]!=false) continue;
            if(Com[now][i]!=1) continue;
            dfs(i);
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        N = n;
        Com = computers;
        
        int answer = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}