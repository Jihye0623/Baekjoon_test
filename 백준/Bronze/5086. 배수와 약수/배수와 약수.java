import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a==0 && b==0) break;
            
            int flag = 0;
            if(a>b){
                if(a%b==0){
                    sb.append("multiple").append("\n");
                    flag = 1;
                }
            }
            else{
                if(b%a==0){
                    sb.append("factor").append("\n");
                    flag = 1;
                }
            }
            
            if(flag == 0) sb.append("neither").append("\n");
        }
		
        System.out.println(sb.toString());
    }
}