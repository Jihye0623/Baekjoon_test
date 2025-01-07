#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{
int n;
cin >> n;
vector<long long> road;
for (int i = 0; i < n - 1; i++) {
long long u;
cin >> u;
road.push_back(u);
}
vector<long long> city;
for (int i = 0; i < n; i++) {
long long u;
cin >> u;
city.push_back(u);
}
long long total_cost = city[0] * road[0];
long long current_cost = city[0];
for (int i = 1; i < n-1; i++) {
current_cost = min(current_cost, city[i]);
total_cost += current_cost * road[i];
}
cout << total_cost;
}