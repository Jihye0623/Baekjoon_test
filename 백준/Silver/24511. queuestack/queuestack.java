import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] type = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            type[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (type[i] == 0) deque.addFirst(temp);
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        for(int i = 0; i<m; i++){
            int temp = Integer.parseInt(st.nextToken());
            deque.addLast(temp);
            sb.append(deque.pollFirst()).append(" ");
        }
        
        System.out.println(sb);
        
    }
}