import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            list.add(k);    
            map.put(k, map.getOrDefault(k,0)+1);
        }
        
        Collections.sort(list);
		StringBuilder sb = new StringBuilder();
        // 산술평균
        double total = 0;
        for(int i : list) total +=  (double)i;
        sb.append(Math.round(total/n)).append("\n");
        
        // 중앙값
        sb.append(list.get(n/2)).append("\n");
        
        // 최빈값
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, new Comparator<Integer>(){
           @Override
            public int compare(Integer o1, Integer o2){
                Integer v1 = map.get(o1);
                Integer v2 = map.get(o2);
                
                int result = Integer.compare(v2,v1);
                if(result == 0) return Integer.compare(o1,o2);
                else return result;
            }
        });

        if(map.size()>1 && map.get(keyList.get(0))==map.get(keyList.get(1))) sb.append(keyList.get(1));
        else sb.append(keyList.get(0));
        sb.append("\n");
        
        
        // 범위
        sb.append(list.get(n-1)-list.get(0)).append("\n");
        
        System.out.println(sb);
    }
}