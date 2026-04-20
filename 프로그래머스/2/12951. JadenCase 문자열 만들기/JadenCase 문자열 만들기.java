import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        
        for(String str:strs){
            char[] charArray = str.toCharArray();
            for(int i = 0; i<charArray.length; i++){
                char c = charArray[i];
                if(i==0){
                    if(c>='a' && c<='z'){
                        sb.append((char)(c+'A'-'a'));
                    }
                    else{
                        sb.append(c);
                    }
                }
                else{
                    if(c>='A' && c<='Z'){
                        sb.append((char)(c-'A'+'a'));
                    }
                    else{
                        sb.append(c);
                    }
                }
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}