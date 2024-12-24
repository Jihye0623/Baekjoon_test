#include <iostream>
#include <algorithm>
using namespace std;
typedef struct {
int x, y;
}st;
char map[21][21];
int N, M;
int dx[] = { 0,0,-1,1 };
int dy[] = { -1,1,0,0 };
bool alpha[26];
bool check(st s) {
if (s.x < 1 || s.y < 1 || s.x > N || s.y > M)
return false;
if (alpha[map[s.x][s.y] - 'A'] == true)
return false;
return true;
}
int dfs(st s) {
alpha[map[s.x][s.y] - 'A'] = true;
int ans = 1;
int level = 0;
for (int i = 0; i < 4; i++) {
st next = { s.x + dx[i], s.y + dy[i] };
if (check(next) == true) {
level = max(level, dfs(next));
alpha[map[next.x][next.y] - 'A'] = false;
}
}
ans += level;
return ans;
}
int main() {
cin >> N >> M;
for (int i = 1; i <= N; i++)
for (int j = 1; j <= M; j++)
cin >> map[i][j];

cout << dfs({ 1, 1 });
return 0;
}