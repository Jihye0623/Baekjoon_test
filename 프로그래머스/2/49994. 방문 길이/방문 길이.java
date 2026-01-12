import java.util.*;

class Solution {
    
    private static HashMap<Character, int[]> direction;
    
    private static void initDirection(){
        direction.put('U', new int[]{0,-1});
        direction.put('D', new int[]{0,1});
        direction.put('L', new int[]{-1,0});
        direction.put('R', new int[]{1,0});
    }
    
    private static boolean isValid(int x, int y){
        return 0<=x && x<11 && 0<=y && y<11;
    }
    
    public int solution(String dirs) {
        direction = new HashMap<>();
        initDirection();
        int x=5, y=5;
        
        HashSet<String> way = new HashSet<>();
        for(int i = 0; i<dirs.length(); i++){
            int[] offset = direction.get(dirs.charAt(i));
            int dx = x + offset[0];
            int dy = y + offset[1];
            if(isValid(dx,dy)){
                way.add(x+" "+y+" " + dx+" "+dy);
                way.add(dx+" "+dy+" " + x+" "+y);
                x = dx;
                y = dy;
            }
        }
        return way.size()/2;
    }
}