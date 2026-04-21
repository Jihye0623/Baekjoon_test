import java.util.*;

class Solution {
    HashSet<Integer> resultSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        resultSet = new HashSet<>();
        
        dfs(0,0, user_id, banned_id);
        
        return resultSet.size();
    }
    
    private void dfs(int depth, int bitmask, String[] user_id, String[] banned_id){
        if(depth == banned_id.length){
            resultSet.add(bitmask);
            return;
        }
        
        for(int i = 0; i<user_id.length; i++){
            if((bitmask & (1<<i)) == 0 && isMatch(user_id[i], banned_id[depth])){
                dfs(depth+1, bitmask|(1<<i), user_id, banned_id);
            }
        }
    }
    
    private boolean isMatch(String user, String ban){
        if(user.length()!=ban.length()) return false;
        
        for(int i = 0; i<user.length(); i++){
            if(ban.charAt(i)=='*') continue;
            if(user.charAt(i)!=ban.charAt(i)) return false;
        }
        return true;
    }
}