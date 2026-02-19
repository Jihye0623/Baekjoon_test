import java.util.*;
import java.io.*;

class Main{
    private static int n, answer;
    private static int[][] map;
    private static boolean[] visited;
    
    private static void backtrack(int idx, int count){
        if(count == n/2){
            calculateDiff();
            return ;
        }
        
        for(int i = idx; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                backtrack(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    private static void calculateDiff(){
        int startSum = 0;
        int linkSum = 0;

        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(visited[i] && visited[j]){
                    startSum += map[i][j];
                    startSum += map[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    linkSum += map[i][j];
                    linkSum += map[j][i];
                }
            }
        }

        int val = Math.abs(startSum - linkSum);
        if(val == 0){
            System.out.println(0);
            System.exit(0);
        }

        answer = Math.min(answer, val);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        answer = Integer.MAX_VALUE;
        visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());        
            }
        }
        
		backtrack(0, 0);
        System.out.println(answer);
    }
}