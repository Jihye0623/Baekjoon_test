import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());  
            String name = st.nextToken();
            String status = st.nextToken();
            if(status.startsWith("e")) set.add(name);
            else set.remove(name);
        }
        
        ArrayList<String> list = new ArrayList<>();
        for(String str:set) list.add(str);
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(String str:list) sb.append(str).append("\n");
        
        System.out.println(sb.toString());
		    
    }
}