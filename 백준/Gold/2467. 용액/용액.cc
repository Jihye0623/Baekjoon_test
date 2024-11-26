#include <cstdio>
#include<math.h>
using namespace std;
int ar[100010];
int main()
{
int n;
scanf("%d", &n);
for (int i = 1; i <= n; i++) {
scanf("%d", &ar[i]);
}
int s = 1;
int e = n;
int Min = 2100000000;
int r, r1;
while (s < e) {
int sum = ar[s] + ar[e];
int a = abs(sum);
if (Min > a) {
Min = a;
r = ar[s];

r1 = ar[e];
}
if (sum > 0) e--;
else if (sum < 0) s++;
else {
printf("%d %d", ar[s], ar[e]);
return 0;
}
}
printf("%d %d", r, r1);
return 0;
}