import java.util.*;
import java.io.*;

class Main{
    public static class Node{
        int u, v;
        double weight;
        
        public Node(int u, int v, double weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

    }

    static int[] parent;

    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa!=pb){
            parent[pa] = pb;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        

        double[][] stars = new double[n][2];
        
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        ArrayList<Node> graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                double dist = Math.sqrt(Math.pow(stars[i][0] - stars[j][0],2) + Math.pow(stars[i][1] - stars[j][1],2));
                graph.add(new Node(i,j, dist));
            }
        }

        Collections.sort(graph, new Comparator<Node>(){
           @Override
            public int compare(Node n1, Node n2){
                return Double.compare(n1.weight, n2.weight);
            }
        });

        parent = new int[n];
        for(int i = 0; i<n; i++) parent[i] = i;

        double total = 0;

        for(Node node: graph){
            if(find(node.u)!=find(node.v)){
                union(node.u, node.v);
                total += node.weight;
            }
        }

        System.out.printf("%.2f", total);
    }
}