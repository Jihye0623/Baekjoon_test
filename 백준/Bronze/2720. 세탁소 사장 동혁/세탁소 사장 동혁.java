import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] money = {25, 10, 5, 1};
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<T; i++){
            int c = Integer.parseInt(br.readLine());
            for(int m : money){
                sb.append(c/m).append(" ");
                c %= m;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        
    }
}