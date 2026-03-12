import java.util.*;
import java.io.*;

class Main{
    private static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(a*b/gcd(b,a)).append("\n");
        }
        
        System.out.println(sb);
        
    }
}