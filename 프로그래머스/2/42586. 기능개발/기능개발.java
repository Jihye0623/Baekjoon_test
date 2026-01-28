import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] leftDays = new int[n];
        for(int i = 0; i<n; i++){
            leftDays[i] = (int)Math.ceil((100-progresses[i])/(double)speeds[i]);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int left: leftDays) queue.addLast(left);
        
        int cnt=1;
        int temp = queue.pollFirst();
        while(!queue.isEmpty()){
            if(temp>=queue.peekFirst()){
                queue.pollFirst();
                cnt+=1;
            }
            else{
                temp = queue.peekFirst();
                answer.add(cnt);
                cnt = 0;
            }
        }
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}