import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String par:participant){
            map.put(par, map.getOrDefault(par,0)+1);
        }
        
        for(String com:completion){
            map.put(com, map.get(com)-1);
            if(map.get(com)==0)
                map.remove(com);
        }
        String answer = "";
        for(String p:participant){
            if(map.containsKey(p)){
                answer = p;
                break;
            }
        }
        return answer;
    }
}