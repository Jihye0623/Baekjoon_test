import java.util.*;

class Solution {
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] dist;
    private static int N, M;
    private static String[] map; 
    
    private static int bfs(Node start, Node end){
        for(int[] d:dist) Arrays.fill(d, 0);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.x == end.x && now.y == end.y) break;
            
            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(0>nx||0>ny||N<=nx||M<=ny) continue;
                if(dist[nx][ny]!=0) continue;
                if(map[nx].charAt(ny)=='X') continue;
                
                dist[nx][ny] = dist[now.x][now.y]+1;
                queue.add(new Node(nx,ny));
            }
        }
        
        
        
        return dist[end.x][end.y]; 
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        dist = new int[N][M];
        map = maps;
        
        Node start = null;
        Node end = null;
        Node lever = null;
        for(int i = 0; i<N; i++){
            for(int j=0; j<M; j++){
                if(maps[i].charAt(j)=='S') start = new Node(i,j);
                else if (maps[i].charAt(j)=='E') end = new Node(i,j);
                else if (maps[i].charAt(j)=='L') lever = new Node(i,j);
            }
        }
        
        int startLever = bfs(start,lever);
        int endLever = bfs(lever, end);
        
        if(startLever == 0 || endLever == 0) return -1;
        else return startLever + endLever;       
        
    }
}