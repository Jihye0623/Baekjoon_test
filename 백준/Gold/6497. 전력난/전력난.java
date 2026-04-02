import java.util.*;
import java.io.*;

class Main{
    private static int[] parent;
    
    private static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    private static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa!=pb){
            parent[pa] = pb;
            return true;
        }
        
        return false;
    }
    
    private static class Node{
        int from, to, cost;
        
        public Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            if(m==0 && n==0) break;
            
            parent = new int[m+1];
            for(int i = 0; i<=m; i++) parent[i] = i;
            
            ArrayList<Node> list = new ArrayList<>();
            int allTotal = 0;
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                
                list.add(new Node(x,y,z));
                allTotal += z;
            }
            
            Collections.sort(list, new Comparator<Node>(){
               @Override 
                public int compare(Node o1, Node o2){
                    return Integer.compare(o1.cost, o2.cost);
                }
            });
            
            int total = 0;
            int count = 0;
            
            for(Node node:list){
                if(union(node.from, node.to)){
                    total += node.cost;
                    count++;
                    
                    if(count == m-1) break;
                }
            }
            
            sb.append(allTotal - total).append("\n");
        }
        
        System.out.println(sb);
    }
}