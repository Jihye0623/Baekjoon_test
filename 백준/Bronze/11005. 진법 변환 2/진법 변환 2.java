import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();

        while(n>0){
            int num = n%b;
            if(num>=10) sb.append((char)('A'+num-10));
            else sb.append(num);
            n /= b;
        }

    
        System.out.println(sb.reverse().toString());
        
    }
}