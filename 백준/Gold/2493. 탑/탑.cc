#include <iostream>
#include <stack>
#include <climits>
#include <vector>
using namespace std;
int main()
{
int n;
cin >> n;
vector<int> ans;
stack<pair<int,int>> s;
s.push({ INT_MAX, 0 });
for (int i = 1; i <= n; i++) {
int h;
cin >> h;
while (s.top().first < h) {
s.pop();
}
ans.push_back(s.top().second);
s.push({h, i});
}
for (int i = 0; i < ans.size(); i++) {
cout << ans[i] << " ";
}
}