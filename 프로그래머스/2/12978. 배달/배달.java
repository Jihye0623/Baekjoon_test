import java.util.*;

class Solution {
    private static class Node{
        int num, cost;
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    private static ArrayList<Node>[] adjList;
    public int solution(int N, int[][] road, int K) {
        adjList = new ArrayList[N+1];
        for(int i = 1; i<N+1; i++) adjList[i] = new ArrayList<>();
        
        for(int[] r:road){
            adjList[r[0]].add(new Node(r[1],r[2]));
            adjList[r[1]].add(new Node(r[0],r[2]));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.cost > dist[now.num]) continue;
            
            for(Node next:adjList[now.num]){
                if(dist[next.num]>now.cost+next.cost){
                    dist[next.num] = now.cost+next.cost;
                    pq.add(new Node(next.num, dist[next.num]));
                }
            }
        }
        
        int cnt = 0;
        for(int d:dist){
            if(d<=K) cnt++;
        }
        
        return cnt;
        
    }
}