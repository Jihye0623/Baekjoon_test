import java.util.*;
import java.io.*;

class Main{
    private static int[] arr;
    private static boolean[] visited;
    
    private static StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static void backTrack(int depth){
        if(depth==m) {
            for(int i:arr) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backTrack(depth+1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n+1];
        backTrack(0);
        
        System.out.println(sb);
    }
}