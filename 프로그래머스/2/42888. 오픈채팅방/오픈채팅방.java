import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Enter", "님이 들어왔습니다.");
        map.put("Leave", "님이 나갔습니다.");
        
        HashMap<String, String> userId = new HashMap<>();        
        for(String rec:record){
            String[] temp = rec.split(" ");
            if(temp.length==3){
                userId.put(temp[1], temp[2]);
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(String rec:record){
            String[] temp = rec.split(" ");
            if(map.containsKey(temp[0])){
                result.add(userId.get(temp[1])+map.get(temp[0]));
            }
        }
        
        String[] answer=  new String[result.size()];
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}