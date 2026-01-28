import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> c1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> c2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> g = new ArrayDeque<>(Arrays.asList(goal));
        
        while(!c1.isEmpty() && !c2.isEmpty() && !g.isEmpty()){
            if(c1.peekFirst().equals(g.peekFirst())){
                g.pollFirst();
                c1.pollFirst();
            } 
            else if(c2.peekFirst().equals(g.peekFirst())){
                g.pollFirst();
                c2.pollFirst();
            }
        }
        while(!g.isEmpty()&&!c1.isEmpty()){
            if(c1.peekFirst().equals(g.peekFirst())){
                g.pollFirst();
                c1.pollFirst();
            } 
            else{
                break;
            }
        }
        
          while(!g.isEmpty() && !c2.isEmpty()){
            if(c2.peekFirst().equals(g.peekFirst())){
                g.pollFirst();
                c2.pollFirst();
            } 
            else{
                break;
            }
        }
        
        return g.isEmpty()? "Yes":"No";
    }
}