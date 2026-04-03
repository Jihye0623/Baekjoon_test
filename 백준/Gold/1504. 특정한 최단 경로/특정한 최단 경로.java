import java.util.*;
import java.io.*;

class Main{
    private static ArrayList<ArrayList<Node>> graph;
    private static int n;    
    
    private static class Node{
        int num, cost;
        
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    private static int[] d(int start){
        int[] distance = new int[n+1];
        for(int i = 0; i<=n; i++) distance[i] = 200000000;
        distance[start] = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>(){
           @Override
            public int compare(Node n1, Node n2){
                return Integer.compare(n1.cost, n2.cost);
            }
        });
        
        queue.add(new Node(start, 0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            if(now.cost > distance[now.num]) continue;
            
            for(Node next:graph.get(now.num)){
                if(distance[next.num]> now.cost + next.cost){
                    distance[next.num] = now.cost + next.cost;
                    queue.add(new Node(next.num, distance[next.num]));
                }
            }
        }
        
        return distance;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int[] from = d(1);
        int[] fromV1 = d(v1);
        int[] fromV2 = d(v2);
        
        int path1 = from[v1] + fromV1[v2] + fromV2[n];
        int path2 = from[v2] + fromV2[v1] + fromV1[n];

        if(path1>=200000000 && path2>=200000000) System.out.println(-1);
        else System.out.println(Math.min(path1, path2));
    }
}