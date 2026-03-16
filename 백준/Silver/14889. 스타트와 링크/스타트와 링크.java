import java.util.*;
import java.io.*;

class Main{
    private static int n, answer = Integer.MAX_VALUE;
    private static int[][] arr;
    private static boolean[] visited;
    
    private static void backTrack(int idx, int depth){
        if(depth==n/2){
            calculateDiff();
            return;
        }
        
        for(int i = idx; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                backTrack(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
    
    private static void calculateDiff(){
        int start = 0;
        int link = 0;
        
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(visited[i] && visited[j]){
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }
        
        int val = Math.abs(start-link);
        if(val==0){
            System.out.println(0);
            System.exit(0);
        }
        answer = Math.min(answer, val);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        arr = new int[n][n];
        visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        backTrack(0,0);
        
        System.out.println(answer);
        
    }
}