import java.util.*;
import java.io.*;

class Main{
    private static int[] parent;
    
    private static class Node{
        int from, to, cost;
        
        public Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
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
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<Node> graph = new ArrayList<>();
        parent = new int[v+1];
        for(int i = 0; i<=v; i++){
            parent[i] = i;
        }
        
        
        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph.add(new Node(a,b,c));
        }
        
        Collections.sort(graph, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return Integer.compare(o1.cost, o2.cost);
            }
        });
        
        int cnt = 0;
        int total = 0;
        
        for(Node node:graph){
            if(union(node.from, node.to)){
                total+= node.cost;
                if(cnt==v-1) break;   
            }
        }
        
        System.out.println(total);
    }
}