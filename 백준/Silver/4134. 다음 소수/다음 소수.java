import java.util.*;
import java.io.*;

class Main{
    
    private static boolean check(long k){
        if(k<=1) return false;
        for(long i = 2; i*i<=k; i++){
            if(k%i==0) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++){
            long k = Long.parseLong(br.readLine());
            while(true){
                if(check(k)) break;
                k++;
            }
            sb.append(k).append("\n");
        }
        
        System.out.println(sb);
		    
    }
}