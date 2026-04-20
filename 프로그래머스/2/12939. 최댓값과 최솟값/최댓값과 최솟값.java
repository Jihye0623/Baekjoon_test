import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ");
        
        int[] arr = new int[strs.length];
        for(int i = 0; i<strs.length; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        sb.append(" ");
        sb.append(arr[arr.length-1]);
        
        return sb.toString();
    }
}