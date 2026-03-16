import java.io.*;
import java.util.*;

class Main{
    private static int n, m;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    
    private static void backTrack(int idx, int depth){
        if(depth==m) {
            for(int a:arr) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i = idx; i<=n; i++){
            arr[depth] = i;
            backTrack(i, depth+1);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        backTrack(1, 0);
        
        System.out.println(sb);
    }
}