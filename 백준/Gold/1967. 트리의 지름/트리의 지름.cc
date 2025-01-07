#include <iostream>
#include <string.h>
#include <vector>
#define MAX 10001
using namespace std;
int n, ans = 0, end_point = 0;
bool visit[MAX];
vector<pair<int, int>> v[MAX];
void dfs(int point, int length) {
if (visit[point])
return;
visit[point] = true;
if (ans < length) {
ans = length;
end_point = point;
}
for (int i = 0; i < v[point].size(); i++) {
pair<int, int> next = v[point][i];
dfs(next.first, length + next.second);
}
}
int main() {
cin >> n;
int parent, child, length;
for (int i = 0; i < n - 1; i++) {
cin >> parent >> child >> length;
v[parent].push_back({ child,length });
v[child].push_back({ parent, length });
}
dfs(1, 0);
ans = 0;
memset(visit, false, sizeof(visit));
dfs(end_point, 0);
cout << ans;
return 0;
}