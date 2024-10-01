#include <cstdio>
#include <algorithm>
using namespace std;
const int M = 100100;
int n, m, x[M], y[M], X, Y;
int s;
int main()
{
int i;
scanf("%d%d", &n, &m);
for (i = 0; i < m; ++i)
scanf("%d%d", &x[i], &y[i]);
sort(x, x + m);
sort(y, y + m);
X = x[m / 2];
Y = y[m / 2];
s = 0;
for (i = 0; i < m; ++i)
s += abs(X - x[i]) + abs(Y - y[i]);
printf("%d\n", s);
return 0;
}