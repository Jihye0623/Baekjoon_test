import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb = new StringBuilder();

    private static class Node{
        int num;
        Node left, right;
        
        public Node(int num){
            this.num = num;
        }
        
        public void insert(int num){
            if(this.num>num) {
                if(this.left==null) this.left = new Node(num);
                else this.left.insert(num);
            }
            else {
                if(this.right==null) this.right = new Node(num);
                else this.right.insert(num);
            }
        }
    }
    
    private static void postorder(Node node){
        if(node==null) return;
        
        postorder(node.left);
        postorder(node.right);
        sb.append(node.num).append("\n");
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Node root = new Node(Integer.parseInt(br.readLine()));
        
        String input = "";
        while((input=br.readLine())!=null && !input.isEmpty()){
            root.insert(Integer.parseInt(input));
        }
        
        postorder(root);
        System.out.println(sb);
    }
}