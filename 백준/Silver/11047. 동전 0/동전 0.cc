#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{
int n, k;
cin >> n >> k;
vector<int> coin;
for (int i = 0; i < n; i++) {
int u;
cin >> u;
coin.push_back(u);
}
int cnt = 0;
for (int i = n - 1; i >= 0; i--) {
cnt += k / coin[i];
k %= coin[i];
}
cout << cnt;
}