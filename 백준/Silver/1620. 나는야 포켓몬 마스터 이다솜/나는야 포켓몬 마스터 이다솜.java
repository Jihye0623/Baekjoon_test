import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, String> numMap = new HashMap<>();
        HashMap<String, Integer> nameMap = new HashMap<>();
        for(int i = 1; i<=n; i++){
            String name = br.readLine();
            numMap.put(i, name);
            nameMap.put(name, i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++){
            String find = br.readLine();
            if(Character.isDigit(find.charAt(0))) sb.append(numMap.get(Integer.parseInt(find)));
            else sb.append(nameMap.get(find));
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}