import java.util.*;
import java.io.*;

class Main{
    private static class Node{
        int x, y;
        double weight;
        
        public Node(int x, int y, double weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    
    private static int[] parent;
    
    private static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa!=pb) parent[pa] = pb;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n+1][2];
        for(int i = 1; i<=n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            
        }
        
        parent = new int[n+1];
        for(int i = 0; i<n+1; i++) parent[i] = i;
        
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            for(int j = i+1; j<=n; j++){
                double dist = Math.sqrt(Math.pow(arr[i][0] - arr[j][0],2) + Math.pow(arr[i][1] - arr[j][1],2));
                list.add(new Node(i,j,dist));
            }
        }
        
        Collections.sort(list, new Comparator<Node>(){
            @Override 
            public int compare(Node n1, Node n2){
                return Double.compare(n1.weight, n2.weight);
            }
        });
        
        double total = 0;
        for(Node node: list){
            if(find(node.x)!=find(node.y)){
                total += node.weight;
                union(node.x, node.y);
            }
        }
        
        System.out.printf("%.2f", total);
    }
}