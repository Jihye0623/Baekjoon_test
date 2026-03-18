import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] time = new int[n][2];
        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(time, new Comparator<int[]>(){
           @Override
           public int compare(int[] op1, int[] op2){
               if(op1[1]==op2[1]) return op1[0] - op2[0];
               return op1[1] - op2[1];
           }
        });
        
        int answer = 0;
        int prev_end_time = 0;
        
        for(int i = 0; i<n; i++){
            if(prev_end_time<=time[i][0]){
                prev_end_time = time[i][1];
                answer++;
            }
            
        }
        
        System.out.println(answer);
    }
}