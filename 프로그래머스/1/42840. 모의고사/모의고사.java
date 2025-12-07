import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] score = new int[3];
        
        for(int i=0;i<answers.length; i++){
            for(int j=0; j<pattern.length; j++){
                if(answers[i]==pattern[j][i%pattern[j].length]){
                    score[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(score).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            if(maxScore==score[i]){
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}