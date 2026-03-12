import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<Integer> s1 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            s1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int minus = 0;
        for(int i = 0; i<m; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(s1.contains(k)) minus++;
        }

        System.out.println(n+m - 2*minus);
        
        
    }
}