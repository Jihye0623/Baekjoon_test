#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{
int n;
cin >> n;
vector<int> v;
for (int i = 0; i < n; i++) {
int u;
cin >> u;
v.push_back(u);
}
int m;
cin >> m;

sort(v.begin(), v.end());
int left = 0;
int right = v[n - 1];
int ans = 0;
while (left <= right) {
int mid = (left + right) / 2;
int sum = 0;
for (int i = 0; i < n; i++) {
sum += min(v[i], mid);
}
if (sum <= m) {
ans = mid;
left = mid + 1;
}
else {
right = mid - 1;
}
}
cout << ans;
}