import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = -1, mi = -1, mj = -1;
        
        for(int i = 1; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<10;j++){
                int num = Integer.parseInt(st.nextToken());
                if(max<num){
                    max = num;
                    mi = i;
                    mj = j;
                }
            }
        }
        
		StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(mi).append(" ").append(mj);
        
        System.out.println(sb.toString());
    }
}