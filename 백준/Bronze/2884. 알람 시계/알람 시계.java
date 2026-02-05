import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if (m>=45) m-= 45;
        else {
            m = 60+m-45;
            h -= 1;
        }
        
        if (h<0) h = 23;
        
        
		StringBuilder sb = new StringBuilder();
        sb.append(h).append(" ").append(m);
        
        System.out.println(sb.toString());
    }
}