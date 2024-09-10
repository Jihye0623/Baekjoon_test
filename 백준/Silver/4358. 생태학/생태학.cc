#include <iostream>
#include <string>
#include <map>
using namespace std;
int main() {
map <string, double> tree;
string s;
int cnt = 0;
while (getline(cin, s)) {
tree[s]++;
cnt++;
}
cout << fixed;
cout.precision(4);
for (auto it : tree) {
cout << it.first << " " << it.second / cnt * 100 << "\n";
}
}