import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int idx = 0;
        int temp = 665;
        while(true){
            if(idx==n) break;
            while(true){
                temp++;
                if(String.valueOf(temp).contains("666")) break;
                
            }
            idx++;
            
        }
        
        
        System.out.println(temp);
    }
}