import java.util.*;
import java.io.*;

class Main{
    private static int N,M;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static int[][] map;
    private static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) queue.add(new Node(i,j));
            }
        }
        
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            for(int i =0 ; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || ny<0 || nx>=N|| ny>= M) continue;
                if(map[nx][ny]!=0) continue;
                map[nx][ny] = map[now.x][now.y] + 1;
                queue.add(new Node(nx,ny));
            }
        }
        int answer = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    System.exit(0);
                }
                if(answer<map[i][j]) answer = map[i][j];
            }
        }
		System.out.println(answer-1);
    }
}