import java.util.*;
import java.io.*;

class Main{
    public static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a*b/gcd(a,b)).append("\n");
        }

        System.out.println(sb.toString());
        
    }
}