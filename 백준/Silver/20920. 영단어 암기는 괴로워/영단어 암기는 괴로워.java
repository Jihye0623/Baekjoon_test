import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            if(word.length() < m) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, new Comparator<String>(){
           @Override
           public int compare(String k1, String k2){
               int v1 = map.get(k1);
               int v2 = map.get(k2);
               int result = Integer.compare(v2,v1);
               if(result != 0) return result;
               
               int len1 = k1.length();
               int len2 = k2.length();
               int result2 = Integer.compare(len2, len1);
               if(result2!=0) return result2;
           
               return k1.compareTo(k2);
           }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String s:keyList) sb.append(s).append("\n");
        System.out.println(sb);
    }
}