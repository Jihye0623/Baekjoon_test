#include <iostream>
#include <stack>
#include <string>
using namespace std;
int main()
{
int t;
cin >> t;
while(t > 0) {
t--;
string str;
cin >> str;
stack<char> s;
int check = 0;
for (int i = 0; i < str.length(); i++) {
if (str[i] == '(') {
s.push(str[i]);
}
else {
if (s.empty() || s.top() == ')') {
check = 1;
break;
}
else {
s.pop();
}
}
}
if (!s.empty() || check) {
cout << "NO" << '\n';
}
else {
cout << "YES" << '\n';
}
}
}