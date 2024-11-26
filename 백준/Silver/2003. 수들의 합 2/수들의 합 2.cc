#include <cstdio>
#include<math.h>
using namespace std;
int ar[10010];

int main()
{
int n, m;
scanf("%d%d", &n,&m);
for (int i = 1; i <= n; i++) {
scanf("%d", &ar[i]);
}
int s = 1;
int e = 1;
int cnt = 0, sum = 0;
while (e<=n+1) {
if (sum < m) sum += ar[e++];
else if (sum > m)sum -= ar[s++];
else {
cnt++;
sum += ar[e++];
}
}
printf("%d", cnt);
return 0;
}