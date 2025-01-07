#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define MAX 100001
using namespace std;
vector<int> v[MAX];
int parent[MAX];
bool visit[MAX];
void dfs(int node) {
visit[node] = true;
int cur = node;
for (int i = 0; i < v[cur].size(); i++) {
int next = v[cur][i];
if (visit[next] == false) {
visit[next] = true;
parent[next] = cur;
dfs(next);
}
}
}
void bfs(int node) {
visit[node] = true;
queue<int> q;
q.push(node);
parent[node] = 0;
while (!q.empty()) {
int cur = q.front();
q.pop();
for (int i = 0; i < v[cur].size(); i++) {
int next = v[cur][i];
if (visit[next] == false) {
visit[next] = true;
parent[next] = cur;
q.push(next);
}
}
}
}

int main() {
int n;
cin >> n;
for (int i = 0; i < n - 1; i++) {
int a, b;
cin >> a >> b;
v[a].push_back(b);
v[b].push_back(a);
}
//bfs(1);
dfs(1);
for (int i = 2; i <= n; i++)
cout << parent[i] << "\n";
return 0;
}