import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 0;
        int idx = 1;
        while (num<n){
            num += idx++;
        }
        idx--;
        n = n - num + idx;
        
        StringBuilder sb = new StringBuilder();
        if(idx%2==0){
            int x = 1, y = idx;
            for(int i = 1; i<n; i++){
                x++;
                y--;
            }
            sb.append(x).append("/").append(y);
        }
        else{
            int x = idx, y = 1;
            for(int i = 1; i<n; i++){
                x--;
                y++;
            }
            sb.append(x).append("/").append(y);
        }

        System.out.println(sb.toString());
    }
}