import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<String> arr = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            String str = br.readLine();
            if(arr.contains(str)) continue;
            arr.add(str);
        }
        
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String op1, String op2){
                int o1 = op1.length();
                int o2 = op2.length();
                
                int result = Integer.compare(o1,o2);
                if(result == 0) return op1.compareTo(op2);
                else return result;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String op: arr){
            sb.append(op).append("\n");
        }
        
        System.out.println(sb);
    
    }
}