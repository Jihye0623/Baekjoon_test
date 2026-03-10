import java.io.*;
import java.util.*;

class Main{
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int M, N, answer;
    private static int[][] map;
    private static boolean[][] visited;
    
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
            if(nx<0 || nx>=M || ny <0 || ny >=N) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny]==0) continue; 
            
            dfs(new Node(nx, ny));
        }
            
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            map = new int[M][N];
            visited = new boolean[M][N];
            
            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[X][Y] = 1;
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