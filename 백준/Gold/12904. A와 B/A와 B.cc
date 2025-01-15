#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main()
{
string s, t;
cin >> s >> t;
int s_length = s.length();
int t_length = t.length();
while (t_length > s_length) {
char c = t[t_length - 1];
t = t.substr(0, t_length - 1);
if (c == 'B') {
reverse(t.begin(), t.end());
}
t_length--;
}
int ans = 0;
if (s.compare(t) == 0) {
ans = 1;
}
cout << ans;
}