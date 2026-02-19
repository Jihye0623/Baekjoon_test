import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            if (k==0){
                if(queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            }
            else queue.add(k);
        }
		    
        System.out.println(sb);
    }
}