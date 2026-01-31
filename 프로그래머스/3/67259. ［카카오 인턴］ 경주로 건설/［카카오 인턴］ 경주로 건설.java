import java.util.*;

class Solution {
    private static int[][][] visited;
    private static class Node{
        int x, y, direction, cost;
        public Node(int x, int y, int direction, int cost){
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    private static int[] dx = {0,-1,0,1};
    private static int[] dy = {-1,0,1,0};
    
    
    private static int calCost(int prevDirect, int direct, int nowCost){
        if(prevDirect == -1 || (prevDirect-direct)%2==0) return nowCost + 100;
        else return nowCost+600;
    }
    
    private static boolean isShouldUpdate(int x, int y, int direction, int newCost){
        return visited[x][y][direction] ==0 || visited[x][y][direction] > newCost;
    }
    
    public int solution(int[][] board) {
        int N = board.length;
        visited = new int[N][N][4];
        int answer = Integer.MAX_VALUE;
        
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0,0,-1,0));
        
        while(!deque.isEmpty()){
            Node now = deque.poll();
            
            for(int i = 0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                
                // 벽이거나 범위를 넘어간 경우
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(board[nx][ny]==1) continue;
                
                int newCost = calCost(now.direction, i, now.cost);
                if(nx == N-1 && ny == N-1) answer = Math.min(newCost, answer);
                else if(isShouldUpdate(nx,ny,i, newCost)){
                    deque.add(new Node(nx,ny,i,newCost));
                    visited[nx][ny][i] = newCost;
                }                    
            }
        }
        
        return answer;
    }
}