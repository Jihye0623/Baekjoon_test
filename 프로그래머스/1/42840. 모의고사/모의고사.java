import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] way = {{1,2,3,4,5},
                     {2,1,2,3,2,4,2,5},
                     {3,3,1,1,2,2,4,4,5,5}};
        
        int[] score = new int[3];

        for(int i = 0; i<3; i++){
            for(int j = 0; j<answers.length; j++){
                if(answers[j] == way[i][j%way[i].length]){
                     score[i] += 1;
                }
            }
        }
        
        int getMax = 0;
        for(int i = 0; i<3; i++){
            if(getMax<score[i])
                getMax = score[i];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i<3; i++){
            if(getMax==score[i])
                result.add(i+1);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}