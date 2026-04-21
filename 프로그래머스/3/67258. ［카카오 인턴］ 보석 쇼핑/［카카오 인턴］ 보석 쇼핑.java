import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        for(String gem:gems) set.add(gem);
        int N = set.size();
        
        int start = 0;
        int length = Integer.MAX_VALUE;
        int[] answer = new int[2];
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int end = 0; end<gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end],0)+1);
            
            while(map.size()==N){
                if(end-start<length){
                    length = end-start;
                    answer[0] = start+1;
                    answer[1] = end+1;
                }
                
                map.put(gems[start], map.get(gems[start])-1);
                
                if(map.get(gems[start])==0){
                    map.remove(gems[start]);
                }
                
                start++;
            }
        }
        
        return answer;
    }
}