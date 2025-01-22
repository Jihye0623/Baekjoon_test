#include <iostream>
#include <vector>
using namespace std;
int main()
{
long long n, meter;
cin >> n >> meter;
vector<long long> tree;
for (int i = 0; i < n; i++) {
long long h;
cin >> h;
tree.push_back(h);
}
long long ans = 0;
long long start = 0;
long long end = 1000000000;
while (start <= end) {
long long middle = (start + end) / 2;
long long sum = 0;
for (int i = 0; i < n; i++) {
if (tree[i] - middle > 0) {
sum += tree[i] - middle;
}
}
if (sum < meter) {
end = middle - 1;
}
else {
ans = middle;
start = middle + 1;
}
}
cout << ans;
}