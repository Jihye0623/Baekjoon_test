#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
bool cmp(pair<int,int> p1, pair<int,int> p2);
int main()
{
int n;
cin >> n;
vector<pair<int, int>> v;
for (int i = 0; i < n; i++) {
int a, b;
cin >> a >> b;
v.push_back({ a, b });
}
sort(v.begin(), v.end(), cmp);
int cnt = 0;
int time = 0;
for (int i = 0; i < v.size(); i++) {
if (time <= v[i].first) {
time = v[i].second;
cnt++;
}
}
cout << cnt;
}
bool cmp(pair<int, int> p1, pair<int, int> p2) {
if (p1.second == p2.second) {
return p1.first < p2.first;
}
return p1.second < p2.second;
}