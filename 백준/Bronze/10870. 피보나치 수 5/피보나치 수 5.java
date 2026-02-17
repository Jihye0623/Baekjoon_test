import java.util.*;
import java.io.*;


class Main{
    
    private static long fibo(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        else {
            return fibo(n-1) + fibo(n-2);        
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }
}