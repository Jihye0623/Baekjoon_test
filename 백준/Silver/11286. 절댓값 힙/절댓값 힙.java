import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if(abs1==abs2) return Integer.compare(o1, o2);
                else return Integer.compare(abs1,abs2);
                
            }
        });
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