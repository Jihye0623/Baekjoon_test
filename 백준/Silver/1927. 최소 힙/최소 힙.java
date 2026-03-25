import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            if(k==0){
                if(queue.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else{
                queue.add(k);
            }
        }
        
        System.out.println(sb);
    }
}