import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> s1 = new HashSet<>();
		ArrayList<String> arr = new ArrayList<>();
        
        for(int i = 0; i<n; i++) s1.add(br.readLine());
        for(int i = 0; i<m; i++) {
            String s = br.readLine();
            if(s1.contains(s)) arr.add(s);
        }
        
        Collections.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(String s:arr) sb.append(s).append("\n");
        
        System.out.println(arr.size());
        System.out.println(sb);
    }
}