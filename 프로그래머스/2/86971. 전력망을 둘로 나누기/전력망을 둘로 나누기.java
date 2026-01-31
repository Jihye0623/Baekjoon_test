import java.util.*;

class Solution {
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    
    private static int dfs(int now){
        visited[now] = true;
        int cnt = 1;
        
        for(int next:adjList[now]){
            if(!visited[next]){
                
                visited[next] = true;
                cnt+=dfs(next);
            }
        }
        
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        visited = new boolean[n+1];
        adjList = new ArrayList[n+1];
        
        for(int i = 1; i<n+1; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] wire:wires){
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        
        int answer = n-2;
        
        for(int[] wire:wires){
            int w1 = wire[0];
            int w2 = wire[1];
            
            adjList[w1].remove(Integer.valueOf(w2));
            adjList[w2].remove(Integer.valueOf(w1));
            
            
            visited = new boolean[n+1];
            int temp = dfs(w1);
            int diff = Math.abs(n - (temp*2));
            answer = Math.min(diff, answer);
            
            adjList[w1].add(w2);
            adjList[w2].add(w1);
        }
        
        return answer;
    }
}