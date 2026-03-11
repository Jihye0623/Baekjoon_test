import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            
            arr.add(temp);
        }
        
        Collections.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] op1, int[] op2){
                int x1 = op1[0];
                int x2 = op2[0];
                
                int result = Integer.compare(x1,x2);
                if(result == 0) return Integer.compare(op1[1], op2[1]);
                else return result;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int[] op: arr){
            sb.append(op[0]).append(" ").append(op[1]).append("\n");
        }
        
        System.out.println(sb);
    
    }
}