import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine())-1;
        if(n==0){
            System.out.println(1);
            return;
        }
        
        int answer=1;
        int total = 6;
        while(true){
            if(total>=n) break;
            answer++;
            total = 6*answer + total;
        }
        System.out.println(answer+1);

    }
}