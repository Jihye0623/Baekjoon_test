import java.util.*;
import java.io.*;

class Main{
    
    private static boolean check(int k){
        if(k<=1) return false;
        for(int i = 2; i*i<=k; i++){
            if(k%i==0) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = M; i<=N; i++){
            if(check(i)) sb.append(i).append("\n");
        }
        
        System.out.println(sb);
		    
    }
}