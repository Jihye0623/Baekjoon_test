import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
       
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            int value = Integer.parseInt(st.nextToken());
            deque.add(new int[]{i, value});
        }

        StringBuilder sb = new StringBuilder();
        int[] current = deque.pollFirst();
        sb.append(current[0]);
        
        int moveValue = current[1];
        
        while(!deque.isEmpty()){
            if(moveValue>0){
                for(int i = 0; i<moveValue-1; i++){
                    deque.addLast(deque.pollFirst());
                }
            }
            else{
                for(int i=0; i<-moveValue; i++){
                    deque.addFirst(deque.pollLast());
                }
            }
            
            current = deque.pollFirst();
            sb.append(" ").append(current[0]);
            moveValue = current[1];
        }
        
        System.out.println(sb);
        
    }
}