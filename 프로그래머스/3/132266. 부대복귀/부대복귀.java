import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] road:roads){
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }
        
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(destination);
        visited[destination] = 0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int next:adjList.get(now)){
                if(visited[next]==-1){
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i = 0; i<sources.length; i++){
            answer[i] = visited[sources[i]];
        }
        
        return answer;
    }
}