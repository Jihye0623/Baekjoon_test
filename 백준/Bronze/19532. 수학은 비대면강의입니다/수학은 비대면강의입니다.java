import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        
        int X = 0, Y = 0;
        
        for(int x = -999; x<=999; x++){
            for(int y = -999; y<=999; y++){
                int left = a*x + b*y;
                int right = d*x + e*y;
                if(left == c && right == f){
                    X = x;
                    Y = y;
                    break;
                }
            }
        }
        
        System.out.println(X +" "+Y);
        
    }
}