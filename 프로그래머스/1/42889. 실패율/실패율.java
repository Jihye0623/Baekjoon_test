import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] ch = new int[N+2];
        for(int i = 0; i<stages.length; i++){
            ch[stages[i]]++;
        }
        
        HashMap<Integer, Double> fail = new HashMap<>();
        double totalPerson = stages.length;
        
        for(int i=1; i<=N; i++){
            if(ch[i]==0){
                fail.put(i, 0.);
            }
            else{
            fail.put(i, (double)ch[i]/totalPerson);
            totalPerson -= ch[i];   
            }
        }
        
        List<Integer> keyList = new ArrayList<>(fail.keySet());
        Collections.sort(keyList, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                Double v1 = fail.get(o1);
                Double v2 = fail.get(o2);
                
                int compareResult = Double.compare(v2, v1);
                if(compareResult==0){
                    return Integer.compare(o1,o2);
                }
                return compareResult;
            }
        });
        
        int[] answer = new int[N];
        for(int i=0; i<keyList.size(); i++){
            answer[i] = keyList.get(i);
        }
        
        return answer;
    }
}