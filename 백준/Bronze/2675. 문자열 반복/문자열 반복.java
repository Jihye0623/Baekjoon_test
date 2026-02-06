import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for(int k = 0; k<str.length(); k++){
                for(int j = 0; j<n; j++){
                    sb.append(str.charAt(k));
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
		    
    }
}