import java.util.*;
import java.io.*;

class Main{
    private static int M,N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    
    private static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private static void dfs(Node now){
        visited[now.x][now.y] = true;
        
        for(int i = 0; i<4; i++){
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            
            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(visited[nx][ny] || map[nx][ny]==0) continue;
            
            dfs(new Node(nx,ny));
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        
        for(int t = 0; t<T; t++){
            st = new StringTokenizer(br.readLine());    
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];
            
            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine());   
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            
            int cnt = 0;
            for(int i = 0; i<M; i++){
                for(int j = 0; j<N; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        dfs(new Node(i,j));   
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
            
        }
        
        System.out.println(sb);
		    
    }
}