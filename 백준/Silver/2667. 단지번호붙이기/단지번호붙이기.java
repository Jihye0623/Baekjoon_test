import java.util.*;
import java.io.*;

class Main{
    private static int[][] map;
    private static boolean[][] visited;
    private static int n;
    
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    
    private static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private static int dfs(Node now){
        visited[now.x][now.y] = true;
        int cnt = 1;
        
        for(int i = 0; i<4; i++){
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            
            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny]==0) continue;
            
            cnt += dfs(new Node(nx,ny));
        }
        
        return cnt;
    }
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];    
        visited = new boolean[n][n];
        
        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<n; j++){
                map[i][j] = (int)(str.charAt(j) - '0');
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j] && map[i][j]!=0){
                    list.add(dfs(new Node(i,j)));
                }   
            }
        }
        
        Collections.sort(list);
        
        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for(int i:list) sb.append(i).append("\n");
        System.out.println(sb);
    }
}