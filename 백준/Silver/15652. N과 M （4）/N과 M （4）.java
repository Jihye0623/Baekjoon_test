import java.util.*;
import java.io.*;

class Main{
    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    
    private static void backtrack(int start, int depth){
        if(depth == M) {
            for(int i:arr) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i = start; i<=N; i++){
            arr[depth] = i;
            backtrack(i, depth+1);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        
        backtrack(1, 0);
        
        System.out.println(sb);
        
    }
}