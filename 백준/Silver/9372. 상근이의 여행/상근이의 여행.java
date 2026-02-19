import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        for(int i = 0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for(int j = 0; j<m; j++) br.readLine();
            sb.append(n-1).append("\n");
        }
        System.out.println(sb);
    }
}