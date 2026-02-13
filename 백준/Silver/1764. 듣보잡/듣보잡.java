import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for(int i = 0; i<n; i++){
            set1.add(br.readLine());
        }
        for(int i = 0; i<m; i++){
            set2.add(br.readLine());
        }
        
        int cnt = 0;
        ArrayList<String> list = new ArrayList<>();
        for(String str:set1){
            if(set2.contains(str)){
                cnt++;
                list.add(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for(String str:list) sb.append(str).append("\n");
        
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}