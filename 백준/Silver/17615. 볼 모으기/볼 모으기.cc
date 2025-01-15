#include <iostream>
#include <string>
#include <climits>
#include <algorithm>
using namespace std;
int main()
{
int n;
cin >> n;
string s;
cin >> s;
int ans = INT_MAX;
int cnt = 0;
int flag = 0;
for (int i = 0; i < n; i++) {
if (s[i] != 'R') {
flag = 1;
}
else if (flag == 1 && s[i] == 'R') {
cnt++;
}
}
ans = min(ans, cnt);
cnt = 0;
flag = 0;
for (int i = n-1; i >= 0; i--) {
if (s[i] != 'R') {
flag = 1;
}
else if (flag == 1 && s[i] == 'R') {
cnt++;
}
}
ans = min(ans, cnt);

cnt = 0;
flag = 0;
for (int i = 0; i < n; i++) {
if (s[i] != 'B') {
flag = 1;
}
else if (flag == 1 && s[i] == 'B') {
cnt++;
}
}
ans = min(ans, cnt);
cnt = 0;
flag = 0;
for (int i = n - 1; i >= 0; i--) {
if (s[i] != 'B') {
flag = 1;
}
else if (flag == 1 && s[i] == 'B') {
cnt++;
}
}
ans = min(ans, cnt);
cout << ans;
}