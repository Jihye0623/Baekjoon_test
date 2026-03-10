import java.util.*;
import java.io.*;

class Main{
    
    private static int[] dx = {-2, -1, 1, 2, -2, -1, 1,2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2,-1};
    private static int cnt, targetX, targetY, L;
    private static boolean[][] visited;
    
    private static class Node{
        int x, y, cnt;
        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    private static boolean isValid(int x, int y){
        if(0>x || x>=L || 0>y || y>=L) return false;
        if(visited[x][y]) return false;
        return true;
    }
    
    private static int bfs(Node start){
        if(start.x == targetX && start.y == targetY) return start.cnt;
        visited[start.x][start.y] = true;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(start);
        
        while(!deque.isEmpty()){
            Node now = deque.pollFirst();
            for(int i = 0; i<8; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(!isValid(nx,ny)) continue;
                if(nx == targetX && ny == targetY) return now.cnt + 1;
                visited[nx][ny] = true;
                deque.addLast(new Node(nx, ny, now.cnt + 1));                
            }
        }

        return -1;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t<T; t++){
            L = Integer.parseInt(br.readLine());
            visited = new boolean[L][L];
            
            st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());
            
            cnt = 0;
            sb.append(bfs(new Node(nowX, nowY, 0))).append("\n");
            
        }
        
        System.out.println(sb);
		    
    }
}