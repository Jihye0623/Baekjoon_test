import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreTop = new HashMap<>();
        HashMap<String, ArrayList<int[]>> playTop = new HashMap<>();
        
        for(int i = 0; i<plays.length; i++){
            String g = genres[i];
            int p = plays[i];
            genreTop.put(g, genreTop.getOrDefault(g,0)+p);
            if(!playTop.containsKey(g)){
                playTop.put(g, new ArrayList<>());
            }
            ArrayList<int[]> tempList = playTop.get(g);
            tempList.add(new int[]{i, p});
            playTop.put(g, tempList);
        }
        
        ArrayList<String> keyList = new ArrayList<>(genreTop.keySet());
        Collections.sort(keyList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                Integer o1 = genreTop.get(s1);
                Integer o2 = genreTop.get(s2);
                return Integer.compare(o2,o1);
            }
        });
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(String key:keyList){
            ArrayList<int[]> songs = playTop.get(key);
            int n = songs.size()>2? 2:songs.size();
            Collections.sort(songs, (o1,o2)-> Integer.compare(o1[1],o2[1])==0? Integer.compare(o1[0],o2[0]):Integer.compare(o2[1], o1[1]));
            for(int i = 0; i<n; i++){
                answer.add(songs.get(i)[0]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}