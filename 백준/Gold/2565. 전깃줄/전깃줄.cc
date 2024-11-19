#include<cstdio>
#include<algorithm>
using namespace std;
pair<int, int> ar[101];
int dp[101];
int main()
{
int n;
scanf("%d", &n);
for (int i = 0; i < n; i++) {
scanf("%d%d", &ar[i].first, &ar[i].second);
}
sort(ar, ar + n);
dp[0] = 1;
int Max = 1;
for (int i = 1; i < n; i++) {
dp[i] = 1;
int M = 0;
for (int j = 0; j < i; j++) {
if (ar[i].second > ar[j].second && dp[j] > M) {
M = dp[j];
}
}
dp[i] = M + 1;
if (Max < dp[i]) {
Max = dp[i];
}
}
printf("%d", n-Max);
}