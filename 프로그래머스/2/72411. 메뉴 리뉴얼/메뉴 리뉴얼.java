import java.util.*;

class Solution {
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    
    private static void combination(int idx, char[] order, String result){
        if(courseMap.containsKey(result.length())){
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0)+1);
        }
        
        for(int i = idx; i<order.length; i++){
            combination(i+1, order, result+order[i]);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        for(int c:course){
            courseMap.put(c, new HashMap<>());
        }
        
        for(String order:orders){
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combination(0, orderArray,"");
        }
        
        ArrayList<String> result = new ArrayList<>();
        
        for(HashMap<String, Integer> count : courseMap.values()){
            int maxMenu = 0;
            for(Map.Entry<String, Integer> entry: count.entrySet()){
                if(entry.getValue()>=2)
                    if(maxMenu<entry.getValue()) 
                        maxMenu = entry.getValue();
            }
            
            for(Map.Entry<String, Integer> entry: count.entrySet()){
                if(entry.getValue()==maxMenu)
                    result.add(entry.getKey());
            }
        }
        
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}