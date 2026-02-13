import java.util.*;
import java.io.*;

class Main{
    private static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        
        int x = ax*by + bx*ay;
        int y = ay*by;
        
        int g = gcd(x,y);
        System.out.println(x/g + " " +y/g);
    }
}