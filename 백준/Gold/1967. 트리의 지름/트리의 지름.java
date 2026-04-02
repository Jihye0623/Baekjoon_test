import java.io.*;
import java.util.*;

class Main{
    
    private static int result = 0, depart = 1;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Node>> tree;
    
    private static class Node{
        int num, cost;
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    private static void dfs(int now, int sum){
        if(result<sum){
            depart = now;
            result = sum;
        }
        
        for(Node next: tree.get(now)){
            if(!visited[next.num]){
                visited[next.num] = true;
                dfs(next.num, sum + next.cost);
            }
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==1){
            System.out.println(0);
            return ;
        }

        
        tree = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            tree.get(a).add(new Node(b,c));
            tree.get(b).add(new Node(a,c));
        }
        
        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1,0);
        visited = new boolean[n+1];
        visited[depart] = true;
        dfs(depart,0);
        
        System.out.println(result);
    }
}