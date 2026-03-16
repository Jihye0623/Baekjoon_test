import java.util.*;
import java.io.*;

class Main{
    private static StringBuilder sb;
    private static void recursive(int n){
        if(n==1){
            sb.append("-");
        }
        else{
            recursive(n/3);
            for(int i = 0; i<n/3; i++){
                sb.append(" ");
            }
            recursive(n/3);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
  
        String input = "";
        
        while((input=br.readLine())!=null && !input.isEmpty()){
            int n = Integer.parseInt(input);
            n = (int)Math.pow(3,n);
            
            recursive(n);
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}