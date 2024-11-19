#include<cstdio>
int ar[1001];
int dp[1001];
int main()
{
int max = 1, N;
dp[0] = 1;
scanf("%d", &N);
for (int i = 0; i < N; i++) {
scanf("%d", ar + i);
}
for (int i = 1; i < N; i++) {
int M = 0;
for (int j = 0; j < i; j++) {
if (ar[i] > ar[j] && dp[j] > M) {
M = dp[j];
}
}
dp[i] = M + 1;
if (max < dp[i]) {
max = dp[i];
}
}
printf("%d", max);
}