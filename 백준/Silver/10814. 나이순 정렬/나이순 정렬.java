import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
             
        ArrayList<String[]> arr = new ArrayList<>();
        for(int i = 0; i<n; i++){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            
            arr.add(new String[]{age, name});
        }
        
        Collections.sort(arr, new Comparator<String[]>(){
            @Override
            public int compare(String[] op1, String[] op2){
                int o1 = Integer.parseInt(op1[0]);
                int o2 = Integer.parseInt(op2[0]);
                
                int result = Integer.compare(o1,o2);
                return result;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String[] op: arr){
            sb.append(op[0]).append(" ").append(op[1]).append("\n");
        }
        
        System.out.println(sb);
    
    }
}