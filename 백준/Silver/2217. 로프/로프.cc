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
sort(v.begin(), v.end());
int ans = 0;
int temp;
for (int i = 0; i < n; i++) {
temp = v[i] * (n - i);
ans = max(ans, temp);
}
cout << ans;
}