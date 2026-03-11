import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==0 && b==0 && c==0) break;
            int max = Math.max(a, Math.max(b,c));
                
            if(a==b && b==c) sb.append("Equilateral");
            else if(max>=(a+b+c-max)) sb.append("Invalid");
            else if (a!=b && b!=c && a!=c) sb.append("Scalene");
            else sb.append("Isosceles");
            sb.append("\n");
        }
        
        System.out.println(sb);
		    
    }
}