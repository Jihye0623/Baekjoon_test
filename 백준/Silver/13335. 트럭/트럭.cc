#include <iostream>
#include <queue>
#include <vector>
using namespace std;
int main()
{
int n, w, l;
cin >> n >> w >> l;
queue<int> truck;
for (int i = 0; i < n; i++) {
int a;
cin >> a;
truck.push(a);
}
vector<pair<int, int>> bridge;
int sum = 0;
int t = 0;
while (true) {
t++;
if (!bridge.empty()) {
for (int i = 0; i < bridge.size(); i++) {
bridge[i].second++;
}
if (bridge[0].second == w) {
sum -= bridge[0].first;
bridge.erase(bridge.begin());
}
}
if (!truck.empty()) {
int now = truck.front();
if (sum + now <= l) {
bridge.push_back({ now , 0 });
sum += now;
truck.pop();
}
}
if (bridge.size() == 0) {
break;
}
}
cout << t;
}