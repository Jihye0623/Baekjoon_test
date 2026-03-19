import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] road = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n-1; i++){
            road[i] = Long.parseLong(st.nextToken());
        }
        
        long[] city = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            city[i] = Long.parseLong(st.nextToken());
        }
        
        long total_cost = city[0] * road[0];
        long current_cost = city[0];
        
        for(int i = 1; i<n-1; i++){
            current_cost = Math.min(current_cost, city[i]);
            total_cost += current_cost * road[i];
        }
        System.out.println(total_cost);
    }
}
