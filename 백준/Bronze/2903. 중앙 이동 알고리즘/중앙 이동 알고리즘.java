import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = (int)Math.pow(4,n) + 4*(int)Math.pow(2,n-1) + 1;
        
        System.out.println(answer);
       
        
    }
}