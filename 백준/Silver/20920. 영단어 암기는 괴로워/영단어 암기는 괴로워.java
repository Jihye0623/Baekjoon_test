import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> words = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            if(word.length()<m) continue;
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                int cnt1 = map.get(s1);
                int cnt2 = map.get(s2);
                int result1 = Integer.compare(cnt2, cnt1);
                if(result1!=0) return result1;
                
                int len1 = s1.length();
                int len2 = s2.length();
                int result2 = Integer.compare(len2, len1);
                if(result2!=0) return result2;
                
                return s1.compareTo(s2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String s:keyList) sb.append(s).append("\n");
        
        System.out.println(sb);
    }
}