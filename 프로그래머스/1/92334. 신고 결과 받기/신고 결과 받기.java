import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        
        for(String rep:report){
            String[] re = rep.split(" ");
            String userId = re[0];
            String reportedId = re[1];
            if(!map.containsKey(reportedId)){
                map.put(reportedId, new HashSet<>());
            }
            map.get(reportedId).add(userId);
        }
        
        for(Map.Entry<String, HashSet<String>> entry : map.entrySet()){
            if(entry.getValue().size()>=k){
                for(String uid:entry.getValue())
                    count.put(uid, count.getOrDefault(uid,0)+1);
            }
        }
        
        int[] result = new int[id_list.length];
        for(int i = 0; i<id_list.length; i++){
            result[i] = count.getOrDefault(id_list[i], 0);
        }
        
        return result;
    }
}