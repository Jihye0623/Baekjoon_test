import java.util.*;
import java.io.*;

class Main{
    private static final int INF = 20000000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        
        int[][] dist = new int[v+1][v+1];
        for(int i = 1; i<=v; i++){
            for(int j = 1; j<=v; j++){
                dist[i][j] = INF;
            }
        }
        
        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            dist[a][b] = c;
        }
        
        for(int k = 1; k<=v; k++){
            for(int i = 1; i<=v; i++){
                for(int j = 1; j<=v; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int minCycle = INF;
        for(int i = 1; i<=v; i++){
            minCycle = Math.min(minCycle, dist[i][i]);
        }
        
        if(minCycle>=INF) System.out.println(-1);
        else System.out.println(minCycle);
        
    }
}