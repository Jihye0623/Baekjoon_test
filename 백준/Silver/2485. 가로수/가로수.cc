#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int euclidean(int a, int b);
int main()
{
int n;
cin >> n;
vector<int> tree;
for (int i = 0; i < n; i++) {
int u;
cin >> u;
tree.push_back(u);
}
sort(tree.begin(), tree.end());
vector<int> distance;
for (int i = 0; i < n - 1; i++) {
distance.push_back(tree[i + 1] - tree[i]);
}
int gcd = distance[0];
for (int i = 1; i < n - 1; i++) {
gcd = euclidean(gcd, distance[i]);
}
int cnt = 0;
for (int i = 0; i < n - 1; i++) {
cnt += (distance[i] / gcd) - 1;
}
cout << cnt;
}
int euclidean(int a, int b) {
if (b == 0) {
return a;
}
return euclidean(b, a % b);
}