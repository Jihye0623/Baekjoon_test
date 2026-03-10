import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] money = {25,10,5,1};
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<T; i++){
            int c = Integer.parseInt(br.readLine());
            int j = 0;
            int[] temp = new int[4];
            while(c>0){
                temp[j] = c/money[j];
                c %= money[j];
                j++;
            }
            for(int t: temp) sb.append(t).append(" ");
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}