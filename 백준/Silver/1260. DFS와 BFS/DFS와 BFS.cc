#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define MAX 1001
using namespace std;
int n;
int arr[MAX][MAX];
bool visit[MAX];
void dfs(int node) {
int cur = node;
cout << cur << " ";
visit[cur] = true;
for (int i = 1; i <= n; i++) {
int next = i;
if (visit[next] == false && arr[cur][next] == 1)
dfs(next);
}
}
void bfs(int node) {
visit[node] = true;
queue<int> q;
q.push(node);
while (!q.empty()) {
int cur = q.front();
cout << cur << " ";
q.pop();
for (int i = 1; i <= n; i++) {
int next = i;
if (visit[next] == false && arr[cur][next] == 1) {
q.push(next);
visit[next] = true;
}
}
}
}
int main() {

int m, start;
cin >> n >> m >> start;
for (int i = 0; i < m; i++) {
int a, b;
cin >> a >> b;
arr[a][b] = 1;
arr[b][a] = 1;
}
dfs(start);
fill(visit, visit + MAX, false);
cout << "\n";
bfs(start);
return 0;
}