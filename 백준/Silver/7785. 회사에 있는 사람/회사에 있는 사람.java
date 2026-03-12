import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
    
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());   
            String name = st.nextToken();
            String check = st.nextToken();
            
            if(check.startsWith("e")) set.add(name);
            else set.remove(name);
        }
        
        ArrayList<String> answer = new ArrayList<>(set);
        Collections.sort(answer, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String s : answer) sb.append(s).append("\n");
        
        System.out.println(sb);
    }
}