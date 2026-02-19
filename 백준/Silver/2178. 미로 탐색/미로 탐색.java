import java.util.*;
import java.io.*;

class Main{
    private static int[][] map;
    private static int n, m;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    
    private static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private static void bfs(Node start){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(start);
        
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || ny<0 || nx>=n||ny>=m) continue;
                if(map[nx][ny]==0 || map[nx][ny]>1) continue;
                map[nx][ny] = map[now.x][now.y] + 1;
                queue.addLast(new Node(nx,ny));
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        bfs(new Node(0,0));
        System.out.println(map[n-1][m-1]);
    }
}