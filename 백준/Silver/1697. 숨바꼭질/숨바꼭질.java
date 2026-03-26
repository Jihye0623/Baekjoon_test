import java.util.*;
import java.io.*;

class Main{    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        if(N==K){
            System.out.println(0);
            return;
        }
        
        boolean[] visited = new boolean[100001];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{N,0});
        visited[N] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int pos = current[0];
            int time = current[1];
            
            if(pos==K){
                System.out.println(time);
                return;
            }
            
            int[] nextPositions = {pos-1, pos+1, pos*2};
            
            for(int next:nextPositions){
                if(next>=0 && next<=100000 && !visited[next]){
                    visited[next] = true;
                    queue.add(new int[]{next, time+1});
                }
            }
        }
    }
}