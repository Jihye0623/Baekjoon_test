import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        int answer = 0;
        for(int i=0; i<discount.length-9; i++){
            HashMap<String, Integer> temp = new HashMap<>();
            for(int j = i; j<i+10; j++){
                String key = discount[j];
                if(!map.containsKey(key)) continue;
                temp.put(key, temp.getOrDefault(key, 0)+1);
                if (temp.get(key)>map.get(key)) 
                    temp.put(key, temp.get(key)-1);
            }
            if(temp.equals(map)) answer++;
        }
        
        return answer;
    }
}