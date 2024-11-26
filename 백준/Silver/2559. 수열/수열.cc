#include <cstdio>
using namespace std;
int ar[100010];
int main()
{
int n, k;
scanf("%d %d", &n, &k);
for (int i = 1; i <= n; i++)scanf("%d", &ar[i]);
int Max = 0;
for (int i = 1; i <= k; i++) {
Max += ar[i];
}
int s = Max;
for (int i = 1; i <= n - k; i++) {
s = s - ar[i] + ar[i + k];
if (Max < s) {
Max = s;
}
}
printf("%d", Max);
return 0;
}