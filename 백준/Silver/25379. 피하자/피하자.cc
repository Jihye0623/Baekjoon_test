#include <iostream>
#include <vector>
#include <climits>
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
long long even_cnt = 0;
long long even_idx = 0;
for (int i = 0; i < n; i++) {
if (v[i] % 2 == 0) {
even_cnt++;
even_idx += i;
}
}
long long even_left = even_idx - even_cnt * (even_cnt - 1) / 2;

long long odd_cnt = 0;
long long odd_idx = 0;
for (int i = 0; i < n; i++) {
if (v[i] % 2 == 1) {
odd_cnt++;
odd_idx += i;
}
}
long long odd_left = odd_idx - odd_cnt * (odd_cnt - 1) / 2;
long long ans = min(even_left, odd_left);
cout << ans;
}