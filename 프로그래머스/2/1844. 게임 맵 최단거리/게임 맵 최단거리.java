import java.util.*;

class Solution {
    private static class Node{
        int x,y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int[][] visited;
    private static int N, M;
    private static int[][] Map;
    
    private static void bfs(Node start){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start.x][start.y] = 1;
        
        while(!deque.isEmpty()){
            Node now = deque.poll();
            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(0>nx||0>ny||N<=nx||M<=ny) continue;
                if(visited[nx][ny]!=0) continue;
                if(Map[nx][ny]==0) continue;
                
                visited[nx][ny] = visited[now.x][now.y] + 1;
                deque.add(new Node(nx,ny));
            }
        }
    }
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new int[N][M];      
        Map = maps;
        
        bfs(new Node(0,0));
        return visited[N-1][M-1]==0? -1:visited[N-1][M-1];
    }
}