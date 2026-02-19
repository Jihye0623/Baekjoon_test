import java.util.*;
import java.io.*;

class Main{
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<Integer> answer;
    private static int n;
    
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
            if(map[nx][ny]==0) continue;
            if(visited[nx][ny]) continue;
            cnt += dfs(new Node(nx,ny));
        }
        return cnt;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        answer = new ArrayList<>();
        
        ArrayList<Integer> answer =  new ArrayList<>();
        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<n; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j] && map[i][j]!=0){
                    answer.add(dfs(new Node(i,j)));
                }
            }
        }
        
        Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for(int i:answer) sb.append(i).append("\n");

        System.out.println(sb);
    }
}