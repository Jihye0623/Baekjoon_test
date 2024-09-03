#include <iostream>
#include <queue>
using namespace std;
int main()
{
int n;
cin >> n;
queue<int> q;
for (int i = 1; i <= n; i++) {
q.push(i);
}
int t = 0;
while (q.size() > 1) {
t++;
if (t % 2 == 1) {
q.pop();
}
else {
q.push(q.front());
q.pop();
}
}
cout << q.front();
}