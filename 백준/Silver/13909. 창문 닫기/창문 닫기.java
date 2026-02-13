import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
      
        int cnt = 0;

        for(int i = 1; i*i<=n; i++){
            cnt++;
        }
        
        System.out.println(cnt);
        
    }
}