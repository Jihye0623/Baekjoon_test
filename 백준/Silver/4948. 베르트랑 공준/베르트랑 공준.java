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
         
        StringBuilder sb = new StringBuilder();

        while(true){
            int k = Integer.parseInt(br.readLine());
            if(k==0) break;

            int cnt = 0;
            for(int i = k+1; i<=2*k; i++){
                if(check(i)) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        
        System.out.println(sb);
		    
    }
}