import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i<=n; i++) queue.addLast(i);
        
        int i = 1;
        while(queue.size()>1){
            if(i%2==1) queue.pollFirst();
            else {
                queue.addLast(queue.getFirst());
                queue.pollFirst();
            }
            i++;
        }
        
        System.out.println(queue.getFirst());
    }
}