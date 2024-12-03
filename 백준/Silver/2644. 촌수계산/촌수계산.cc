#include <iostream>
#include <queue>

using namespace std;
#define MAX 102

int n;
int arr[MAX][MAX];
int visit[MAX];

void bfs(int node) {
     queue<int> q;
     q.push(node);
     while (!q.empty()) {
          int cur = q.front();
          q.pop();
          for (int i = 1; i <= n; i++) {
               int next = i;
               if (visit[next] == false && arr[cur][next] == 1) {
                    q.push(next);
                    visit[next] = visit[cur] + 1;
               }
          }
     }
}

int main() {
    int target_x,target_y,m;
    
    cin >> n;
    cin >> target_x >> target_y;
    cin >> m;

    for(int i=0;i<m;i++) {
        int x,y;
        cin >> x >> y;
        arr[x][y]=1;
        arr[y][x]=1;
    }

    bfs(target_x);

    if(visit[target_y]==0)
        visit[target_y]=-1;
        
    cout << visit[target_y];
}