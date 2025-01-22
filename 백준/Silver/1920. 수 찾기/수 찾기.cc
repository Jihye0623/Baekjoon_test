#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{
int n;
cin >> n;
vector<int> v1;
for (int i = 0; i < n; i++) {
int u;
cin >> u;
v1.push_back(u);
}
int m;
cin >> m;
vector<int> v2;
for (int i = 0; i < m; i++) {
int u;
cin >> u;
v2.push_back(u);
}

sort(v1.begin(), v1.end());
for (int i = 0; i < m; i++) {
int left = 0;
int right = n-1;
int goal = v2[i];
int flag = 0;
while (left <= right) {
int middle = (left + right) / 2;
if (v1[middle] == goal) {
flag = 1;
break;
}
else if (v1[middle] > goal) {
right = middle - 1;
}
else if (v1[middle] < goal) {
left = middle + 1;
}
}
cout << flag << '\n';
}
}