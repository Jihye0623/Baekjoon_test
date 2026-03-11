import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        
        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==0 && b==0) break;
            if(b%a==0) sb.append("factor\n");
            else if(a%b==0) sb.append("multiple\n");
            else sb.append("neither\n");
        }
        
        System.out.println(sb);
    }
}