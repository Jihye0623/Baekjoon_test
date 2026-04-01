import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        if(n>=k){
            System.out.println(n-k);
            return;
        }
        
        int[] time = new int[100001];
        Arrays.fill(time, -1);
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(n);
        time[n] = 0;
        
        while(!deque.isEmpty()){
            int now = deque.pollFirst();
            if(now == k){
                System.out.println(time[now]);
                return;
            }
            
            int jump = now*2;
            if(jump<=100000 && time[jump]==-1){
                time[jump] = time[now];
                deque.addFirst(jump);
            }
            
            int back = now - 1;
            if(back>=0 && time[back]== -1){
                time[back] = time[now] + 1;
                deque.addLast(back);
            }
            
            int front = now + 1;
            if(front<=100000 && time[front]==-1){
                time[front] = time[now] + 1;
                deque.addLast(front);
            }
        }
        
        
    }
}