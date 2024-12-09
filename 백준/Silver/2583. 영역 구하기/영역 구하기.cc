#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
int map[100][100];
bool visit[100][100];
int n, m, k;
typedef struct {
int x, y;
}st;
int dx[4] = { 1,-1, 0, 0 };
int dy[4] = { 0, 0, 1,-1 };
bool check(int x, int y) {
if (x < 0 || y < 0 || x >= n || y >= m)
return false;
if (visit[x][y] == true)
return false;
if (map[x][y] == 1)
return false;
return true;
}
int dfs(int x, int y) {
visit[x][y] = true;
int cnt = 1;
for (int i = 0; i < 4; i++) {
st next = { x + dx[i], y + dy[i] };
if (check(next.x, next.y) == true)
cnt += dfs(next.x, next.y);

}
return cnt;
}
int bfs(int x, int y) {
visit[x][y] = true;
int cnt = 0;
queue<st> q;
q.push({ x, y });
while (!q.empty()) {
cnt++;

st cur = q.front();
q.pop();
for (int i = 0; i < 4; i++) {
st next = { cur.x + dx[i], cur.y + dy[i] };
if (check(next.x, next.y) == true) {
q.push(next);
visit[next.x][next.y] = true;
}
}
}
return cnt;
}
int main() {
cin >> m >> n >> k;
for (int i = 0; i < k; i++) {
int x1, y1, x2, y2;
cin >> x1 >> y1 >> x2 >> y2;
for (int x = x1; x < x2; x++)
for (int y = y1; y < y2; y++)
map[x][y] = 1;

}
vector<int> ans;
for (int i = 0; i < n; i++)
for (int j = 0; j < m; j++)
if (check(i, j) == true) {
ans.push_back(dfs(i, j));
//ans.push_back(bfs(i, j));
}

cout << ans.size() << "\n";
sort(ans.begin(), ans.end());
for (int i = 0; i < ans.size(); i++)
cout << ans[i] << " ";
return 0;
}