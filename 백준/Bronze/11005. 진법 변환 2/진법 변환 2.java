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
            int temp = n % b;
            if(temp>=10){
                char c = (char)('A'+(temp-10));
                sb.append(c);
            }
            else{
                sb.append(temp);
            }
            n /= b;
        }
        
        sb = sb.reverse();
        System.out.println(sb);
            
    }
}