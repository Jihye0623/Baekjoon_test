import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0 && b==0 && c==0) break;
                
            int max = Math.max(a, Math.max(b,c));

            if (max>=(a+b+c-max)) sb.append("Invalid");
            else if(a==b&&b==c) sb.append("Equilateral");
            else if((a==b && b!=c) || (a!=b && b==c) || (a!=b && a==c)) sb.append("Isosceles");
            else sb.append("Scalene");
            
            
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}