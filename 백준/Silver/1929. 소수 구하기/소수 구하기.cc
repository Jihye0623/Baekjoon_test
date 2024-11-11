#include <iostream>
#include <vector>
using namespace std;
int main()
{
int m, n;
cin >> m >> n;
vector<int> prime;
for (int i = m; i <= n; i++) {
if (i == 1) {
continue;
}
int flag = 0;
for (int j = 2; j * j <= i; j++) {
if (i % j == 0) {
flag = 1;
break;
}
}
if (flag == 0) {
prime.push_back(i);
}
}
for (int i = 0; i < prime.size(); i++) {
cout << prime[i] << '\n';
}
}