import java.util.*;

class Solution {
    private static class Node{
        int node, sheep, wolf;
        HashSet<Integer> visit;
        public Node(int node, int sheep, int wolf, HashSet<Integer> visit){
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visit = visit;
        }
    }
    
    private static ArrayList<Integer>[] adjList;
    
    private static void buildTree(int[] info, int[][] edges){
        adjList = new ArrayList[info.length];
        for(int i = 0; i<info.length; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge:edges){
            adjList[edge[0]].add(edge[1]);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        buildTree(info, edges);
        int answer = 0;
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,1,0,new HashSet<>()));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            answer = Math.max(answer, now.sheep);
            now.visit.addAll(adjList[now.node]);
            
            for(int next:now.visit){
                HashSet<Integer> set = new HashSet<>(now.visit);
                set.remove(next);
                
                if(info[next]==1){
                    if(now.wolf+1<now.sheep){
                        queue.add(new Node(next, now.sheep, now.wolf+1, set));
                    }
                } else{
                    queue.add(new Node(next, now.sheep+1, now.wolf, set));
                }
            }
        }
        
        
        return answer;
    }
}