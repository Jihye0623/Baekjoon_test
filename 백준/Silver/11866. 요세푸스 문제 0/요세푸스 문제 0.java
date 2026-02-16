import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i<=n; i++) queue.addLast(i);
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(queue.size()>1){
            for(int i = 0; i<k-1; i++){
                queue.addLast(queue.getFirst());
                queue.pollFirst();
            }
            sb.append(queue.pollFirst()).append(", ");
        }
        sb.append(queue.pollFirst()).append(">");
        
        System.out.println(sb.toString());
        
        
    }
}