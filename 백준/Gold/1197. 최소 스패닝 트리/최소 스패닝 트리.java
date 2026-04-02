import java.util.*;
import java.io.*;

class Main{
    private static int[] parent;
    
    private static class Edge{
        int from, to, weight;
        
        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    
    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    static boolean union(int a, int b){
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
        
        parent = new int[v+1];
        for(int i = 1; i<=v; i++) parent[i] = i;
        
        ArrayList<Edge> edgeList = new ArrayList<>();
        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(a,b,w));
        }
        
        Collections.sort(edgeList, new Comparator<Edge>(){
            @Override
            public int compare(Edge o1, Edge o2){
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        
        long totalWeight = 0;
        int count = 0;
        
        for(Edge edge:edgeList){
            if(union(edge.from, edge.to)){
                totalWeight += edge.weight;
                count++;
                
                if(count==v-1) break;
            }
        }
        
        System.out.println(totalWeight);
    }
}